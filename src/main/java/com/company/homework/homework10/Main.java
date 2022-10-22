package com.company.homework.homework10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * Попробовал объединить два задания (1 и 2) в одном. Логика программы такова:
 * 1. В файле хранится только объект. Он считывается по надобности в копию (mapForOperation) и работа ведётся с копией. Потом всё перезаписывается
 * обратно в файл.
 * 2. Данные в телефонной книге можно редактировать. Поиск контакта для редактирования по e-mail (поленился писать полноценный поиск по
 * любому полю контакта, спешил сдать просроченную домашку).
 * 3. Данные организованы в HashMap с ключом - e-mail (т.к. он самый уникальный для контакта) и значением в качестве экземпляра класса Contact
 * (непосредственно с данными контакта).
 * 4. Меню сделал примитивно через switch-case, т.к. оно небольшое.
 * 5. Сделаны проверки при запуске программы на существование файла. При отсутствии файла он создаётся и заполняется пустым объектом,
 * для избежания в дальнейшем ошибки IOException при чтении объекта из файла. При желании, можно заполнить тестовыми значениями.
 * 6. Редактирование контакта совмещено с поиском (условие задачи).
 * 7. Не стал делать подробное редактирование найденного контакта по полям. Только базовые операции.
 * 8. При создании контакта, при вводе номеров телефонов производится проверка на уникальность телефонных номеров в базе.
 */
public class Main {

    private static HashMap<String, Object> mapForOperation = new HashMap<>();

    private static final File phoneBookFilePath = new File("/phonebook");
    private static final File phoneBookFile = new File("/phonebook/phoneBookFile.ser");

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        if (createNewFileIfNotExistIfNotEmpty(phoneBookFile, phoneBookFilePath)) {
            System.out.print("The phonebook file present.\n");
        } else {
            System.out.println("The new phonebook file with empty base has been created.\n");
        }

        Scanner scanner = new Scanner(System.in);
        boolean checkExitFromDialog = false;
        do {
            int inputSelected = getInputSelectedInMainMenu(scanner);
            switch (inputSelected) {
                case 1 -> createNewContact(scanner);
                case 2 -> showPhoneBase();
                case 3 -> searchAndEditingContact(scanner);
                case 4 -> fillPhoneBookExampleContacts();
                case 5 -> checkExitFromDialog = true;
                default -> System.out.print("Value not supported.\n");
            }
        } while (!checkExitFromDialog);
        scanner.close();
    }

    private static int getInputSelectedInMainMenu(Scanner scanner) {
        System.out.println();
        System.out.print("Select an action with the phone book:\n");
        System.out.print("""
                1. Create a new contact
                2. Show contacts list.
                3. Search and editing an existing contact by phone number or name of contact.
                4. Fill the phone book with test values if it is empty.
                5. Exit
                Enter number you select:
                """);
        return parseInt(scanner.nextLine());
    }

    private static void searchAndEditingContact(Scanner scanner) {
        mapForOperation.clear();
        readFromFileToMapForOperation();

        System.out.print("Enter the name or phone number of a contact to search and then edit: ");
        String valueForSearching = scanner.nextLine();

        if (valueForSearching.contains("+")) {
            for (Entry<String, Object> entry : mapForOperation.entrySet()) {
                Contact contact = (Contact) entry.getValue();
                if (contact.getMobilePhoneNum().contains(valueForSearching) | contact.getHomePhoneNum().contains(valueForSearching) |
                        contact.getHomePhoneNum().contains(valueForSearching) | contact.getFaxPhoneNum().contains(valueForSearching)) {
                    System.out.printf("Found contact '%s' by phone number '%s'\n", contact.getName(), valueForSearching);
                    System.out.print("What do you want do with the found contact?\n");
                    System.out.print("""
                            1. Delete contact
                            2. Completely replace the contact
                            3. Show all values of contact
                            Enter any number for exit.
                            Enter number you selected:
                            """);
                    int input = parseInt(scanner.nextLine());
                    switch (input) {
                        case 1 -> deleteFoundContactByEMail(contact.getEMAIL_ADDRESS());
                        case 2 -> replaceContact(contact.getEMAIL_ADDRESS(), scanner);
                        case 3 -> showValuesContact(contact.getEMAIL_ADDRESS());
                        default -> System.out.print("Value not supported.\n");
                    }
                    break;
                }
                System.out.print("The phone number you entered was not found in phone book.\n");
                break;
            }
        } else if (!valueForSearching.equals("")) {
            Map<String, Object> tempMap = new HashMap<>();
            for (Entry<String, Object> entry : mapForOperation.entrySet()) {
                Contact contact = (Contact) entry.getValue();
                if (contact.getName().contains(valueForSearching)) {
                    tempMap.putIfAbsent(contact.getEMAIL_ADDRESS(), contact);
                }
            }
            if (tempMap.isEmpty()) {
                System.out.print("This name was not found in the phone book.\n");
            } else {
                System.out.printf("Found contacts with name '%s': \n", valueForSearching);
                tempMap.entrySet().forEach(System.out::println);
                System.out.print("Enter the mobile phone of found contacts which you want to operate: ");
                String mobilePhoneFoundContact = scanner.nextLine();
                for (Entry<String, Object> entry : tempMap.entrySet()) {
                    Contact contact = (Contact) entry.getValue();
                    if (contact.getMobilePhoneNum().contains(mobilePhoneFoundContact)) {
                        System.out.printf("The contact '%s' by name '%s'\n", contact.getName(), mobilePhoneFoundContact);
                        System.out.print("What do you want do with the found contact?\n");
                        System.out.print("""
                                1. Delete contact
                                2. Completely replace the contact
                                3. Show all values of contact
                                Enter any number for exit.
                                Enter number you selected:
                                """);
                        int input = parseInt(scanner.nextLine());
                        switch (input) {
                            case 1 -> deleteFoundContactByEMail(contact.getEMAIL_ADDRESS());
                            case 2 -> replaceContact(contact.getEMAIL_ADDRESS(), scanner);
                            case 3 -> showValuesContact(contact.getEMAIL_ADDRESS());
                            default -> System.out.print("Value not supported.\n");
                        }
                        break;
                    }
                }
            }
        } else {
            System.out.print("No contact details to search.\n");
        }
    }

    private static void showValuesContact(String eMailAddress) {
        readFromFileToMapForOperation();
        System.out.print("Contact information:\n");
        System.out.print(mapForOperation.get(eMailAddress));
        System.out.println();
    }

    private static void replaceContact(String eMailAddress, Scanner scanner) {
        createNewContact(scanner);
        readFromFileToMapForOperation();
        mapForOperation.remove(eMailAddress);
        writeMapForOperationToFile();
        mapForOperation.clear();
        System.out.print("The contact was replace successfully.\n");
    }

    private static void deleteFoundContactByEMail(String eMailAddress) {
        mapForOperation.remove(eMailAddress);
        writeMapForOperationToFile();
        mapForOperation.clear();
        System.out.println("Contact was delete successfully.");
    }

    private static void showPhoneBase() {
        readFromFileToMapForOperation();
        System.out.println();
        System.out.print("Phone book:\n");
        mapForOperation.entrySet().forEach(System.out::println);
    }

    /**
     * Чтение из файла текущей телефонной книги и передача объекта из файла в HashMap для манипуляций с данными
     * "внутри" метода main.
     */
    private static void readFromFileToMapForOperation() {
        try (FileInputStream fileToRead = new FileInputStream(phoneBookFile);
             ObjectInputStream objectToRead = new ObjectInputStream(fileToRead)) {
            mapForOperation = (HashMap<String, Object>) objectToRead.readObject();
            if (mapForOperation.isEmpty()) {
                System.out.print("The phone book is empty.\n");
            }
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Запись в файл после манипуляций с копией телефонной книги.
     */
    private static void writeMapForOperationToFile() {
        try (FileOutputStream fileToWrite = new FileOutputStream(phoneBookFile);
             ObjectOutputStream objectToWrite = new ObjectOutputStream(fileToWrite)) {
            objectToWrite.writeObject(mapForOperation);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Проверка на существование файла и создание нового, в случае отсутствия.
     * Проверка содержимого файла и запись в файл пустого HashMap (объекта телефонной книги).
     *
     * @param phoneBookFile объект для операций с файлом телефонной книги
     */
    public static boolean createNewFileIfNotExistIfNotEmpty(File phoneBookFile, File phoneBookFilePath) {
        if (phoneBookFile.isFile()) {
            return true;
        }
        try {
            boolean newFilePath = phoneBookFilePath.mkdirs();
            boolean newFile = phoneBookFile.createNewFile();
            if (newFile & newFilePath) {
                System.out.println("Created a new file with an empty database");
            }
            writeMapForOperationToFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private static boolean isExistContactByPhoneNumber(String phoneNumber) {
        mapForOperation.clear();
        readFromFileToMapForOperation();
        boolean checkValue = true;
        for (Entry<String, Object> entry : mapForOperation.entrySet()) {
            Contact contact = (Contact) entry.getValue();
            if (contact.getMobilePhoneNum().contains(phoneNumber) || contact.getHomePhoneNum().contains(phoneNumber) ||
                    contact.getWorkPhoneNum().contains(phoneNumber) || contact.getFaxPhoneNum().contains(phoneNumber)) {
                checkValue = true;
                break;
            }
            checkValue = false;
        }
        mapForOperation.clear();
        return checkValue;
    }
// TODO доделать проверку e-mailсоздать дополнительный метод проверки на пустую базу.
    private static boolean isExistContactByEMail(String eMail) {
//        mapForOperation.clear();
        readFromFileToMapForOperation();
        boolean checkValue = true;
//        if () {
            for (Entry<String, Object> entry : mapForOperation.entrySet()) {
                Contact contact = (Contact) entry.getValue();
                if (contact.getEMAIL_ADDRESS().contains(eMail)) {
                    checkValue = true;
                    break;
                }
                checkValue = false;
            }
//        }
        mapForOperation.clear();
        return checkValue;
    }

    public static void createNewContact(Scanner scanner) {
        mapForOperation.clear();

        System.out.print("Enter the name of the new contact: ");
        String newName = scanner.nextLine();
        System.out.print("Enter the surname of the new contact: ");
        String newSurname = scanner.nextLine();
        System.out.print("Enter the nickname of the new contact: ");
        String newNickname = scanner.nextLine();

        System.out.print("Enter the e-mail address of the new contact: ");
        String newEmail = "";
        boolean cycleCheckEmail;
        do {
            String newEmailForCheck = scanner.nextLine();
            newEmailForCheck = newEmailForCheck.toLowerCase(Locale.ROOT);
            Pattern pattern = Pattern.compile("^([\\p{L}-\\.]+){1,64}@([\\p{L}&&[^_]]+){2,255}.[a-z]{2,}$");
            if (pattern.matcher(newEmailForCheck).matches()) {
                if (isExistContactByEMail(newEmailForCheck)) {
                    cycleCheckEmail = true;
                    System.out.print("the email is not valid in format or it is already present in the database. Enter e-mail again: ");
                } else {
                    cycleCheckEmail = false;
                    newEmail = newEmailForCheck;
                    System.out.print("The e-mail address matches the e-mail format and it is not present in phone book and will be add.\n");
                }
            } else {
                cycleCheckEmail = true;
                System.out.print("The email is not valid in format. Enter e-mail again: ");
            }
        } while (cycleCheckEmail);

        System.out.print("Enter your birth year: ");
        Year newBirthYear = Year.parse(scanner.nextLine());

// Adding mobile phone number.
        System.out.print("Enter the mobile phone number or numbers separated by spaces (input format - +71234567890, +7(921)9406233): ");
        String newMobileNum = scanner.nextLine();
        String[] mobileNumArray = newMobileNum.split(" ");
        ArrayList<String> mobilePhoneNumArray = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("^(\\+7)\\d{10}");
        for (String current : mobileNumArray) {
            if (pattern1.matcher(current).matches()) {
                System.out.print("The mobile phone number matches the format.\n");
            } else {
                System.out.printf("""
                        The mobile phone number '%s' was not add. The phone number you entered does not match the format.
                        You can add a mobile phone number to the desired category from the main menu.
                        """, current);
            }
            if (isExistContactByPhoneNumber(current)) {
                System.out.print("""
                        The entered mobile phone number belongs to another contact and will not be added.
                        You can add a mobile phone number to the desired category from the main menu.
                        """);
            } else {
                mobilePhoneNumArray.add(current);
                System.out.println("The mobile phone number was added successfully.");
            }

        }
// Adding home phone number.
        System.out.print("Enter the home phone number or numbers separated by spaces (input format - +71234567890, +7(921)9406233): ");
        String newHomeNum = scanner.nextLine();
        String[] homeNumArray = newHomeNum.split(" ");
        ArrayList<String> homePhoneNumArray = new ArrayList<>();
        Pattern pattern2 = Pattern.compile("^(\\+7)\\d{10}");
        for (String current : homeNumArray) {
            if (pattern2.matcher(current).matches()) {
                System.out.print("The home phone number matches the format.\n");
            } else {
                System.out.printf("""
                        The home phone number '%s' was not add. The phone number you entered does not match the format.
                        You can add a home phone number to the desired category from the main menu.
                        """, current);
            }
            if (isExistContactByPhoneNumber(current)) {
                System.out.print("""
                        The entered home phone number belongs to another contact and will not be added.
                        You can add a home phone number to the desired category from the main menu.
                        """);
            } else {
                homePhoneNumArray.add(current);
                System.out.println("The home number was added successfully.");
            }
        }

// Adding work phone number.
        System.out.print("Enter the work phone number or numbers separated by spaces (input format - +71234567890, +7(921)9406233): ");
        String newWorkNum = scanner.nextLine();
        String[] workNumArray = newWorkNum.split(" ");
        ArrayList<String> workPhoneNumArray = new ArrayList<>();
        Pattern pattern3 = Pattern.compile("^(\\+7)\\d{10}");
        for (String current : workNumArray) {
            if (pattern3.matcher(current).matches()) {
                System.out.print("The work phone number matches the format.\n");
            } else {
                System.out.printf("""
                        The work phone number '%s' was not add. The phone number you entered does not match the format.
                        You can add a work phone number to the desired category from the main menu.
                        """, current);
            }
            if (isExistContactByPhoneNumber(current)) {
                System.out.print("""
                        The entered work phone number belongs to another contact and will not be added.
                        You can add a work phone number to the desired category from the main menu.
                        """);
            } else {
                workPhoneNumArray.add(current);
                System.out.println("The work number was added successfully.");
            }
        }
// Adding fax phone number.
        System.out.print("Enter the fax phone number or numbers separated by spaces (input format - +71234567890, +7(921)9406233): ");
        String newFaxNum = scanner.nextLine();
        String[] faxNumArray = newFaxNum.split(" ");
        ArrayList<String> faxPhoneNumArray = new ArrayList<>();
        Pattern pattern4 = Pattern.compile("^(\\+7)\\d{10}");
        for (String current : faxNumArray) {
            if (pattern4.matcher(current).matches()) {
                System.out.print("The fax phone number matches the format.\n");
            } else {
                System.out.printf("""
                        The fax phone number '%s' was not add. The phone number you entered does not match the format.
                        You can add a fax phone number to the desired category from the main menu.
                        """, current);
            }
            if (isExistContactByPhoneNumber(current)) {
                System.out.print("""
                        The entered fax phone number belongs to another contact and will not be added.
                        You can add a fax phone number to the desired category from the main menu.
                        """);
            } else {
                faxPhoneNumArray.add(current);
                System.out.println("The fax number was added successfully.");
            }
        }
        // Create a contact and record to base.
        Contact newContact = new Contact(newName, newSurname, newNickname, newEmail, newBirthYear, mobilePhoneNumArray, homePhoneNumArray, workPhoneNumArray, faxPhoneNumArray);
        readFromFileToMapForOperation();
        mapForOperation.putIfAbsent(newContact.getEMAIL_ADDRESS(), newContact);
        writeMapForOperationToFile();
        mapForOperation.clear();
    }

    private static void fillPhoneBookExampleContacts() {
        mapForOperation.clear();
        readFromFileToMapForOperation();

        ArrayList<String> mobilePhoneNum = new ArrayList<>();
        mobilePhoneNum.add("+79876543211");
        mobilePhoneNum.add("+79871563248");
        ArrayList<String> homePhoneNum = new ArrayList<>();
        homePhoneNum.add("+79456321485");
        ArrayList<String> workPhoneNum = new ArrayList<>();
        workPhoneNum.add("+79653214524");
        ArrayList<String> faxPhoneNum = new ArrayList<>();
        faxPhoneNum.add("+79844562154");
        Contact contact = new Contact("Alex", "Alex", "alexalex", "abc@abc.ru", Year.parse("1990"),
                mobilePhoneNum, homePhoneNum, workPhoneNum, faxPhoneNum);
        if (!mapForOperation.containsKey(contact.getEMAIL_ADDRESS())) {
            mapForOperation.put(contact.getEMAIL_ADDRESS(), contact);
        } else {
            System.out.printf("Such a contact (e-mail: %s )exists in the phone book and wil not be added.\n", contact.getEMAIL_ADDRESS());
        }
        ArrayList<String> mobilePhoneNum1 = new ArrayList<>();
        mobilePhoneNum1.add("+79874567891");
        mobilePhoneNum1.add("+79873576548");
        ArrayList<String> homePhoneNum1 = new ArrayList<>();
        homePhoneNum1.add("+79451596548");
        ArrayList<String> workPhoneNum1 = new ArrayList<>();
        workPhoneNum1.add("+79657536548");
        ArrayList<String> faxPhoneNum1 = new ArrayList<>();
        faxPhoneNum1.add("+79844564568");
        Contact contact1 = new Contact("Dmitriy", "Dmitriy", "dimdim", "dim@abc.ru", Year.parse("1995"),
                mobilePhoneNum1, homePhoneNum1, workPhoneNum1, faxPhoneNum1);
        if (!mapForOperation.containsKey(contact1.getEMAIL_ADDRESS())) {
            mapForOperation.put(contact1.getEMAIL_ADDRESS(), contact1);
        } else {
            System.out.printf("Such a contact (e-mail: %s )exists in the phone book and wil not be added.\n", contact1.getEMAIL_ADDRESS());
        }
        ArrayList<String> mobilePhoneNum2 = new ArrayList<>();
        mobilePhoneNum2.add("+79874562563");
        mobilePhoneNum2.add("+79873577854");
        ArrayList<String> homePhoneNum2 = new ArrayList<>();
        homePhoneNum2.add("+79451594125");
        ArrayList<String> workPhoneNum2 = new ArrayList<>();
        workPhoneNum2.add("+79657539856");
        ArrayList<String> faxPhoneNum2 = new ArrayList<>();
        faxPhoneNum2.add("+79844563578");
        Contact contact2 = new Contact("Mikhail", "Mikhail", "mihmih", "mih@abc.ru", Year.parse("2000"),
                mobilePhoneNum2, homePhoneNum2, workPhoneNum2, faxPhoneNum2);
        if (!mapForOperation.containsKey(contact2.getEMAIL_ADDRESS())) {
            mapForOperation.put(contact2.getEMAIL_ADDRESS(), contact2);
        } else {
            System.out.printf("Such a contact (e-mail: %s )exists in the phone book and wil not be added.\n", contact2.getEMAIL_ADDRESS());
        }
        writeMapForOperationToFile();
        mapForOperation.clear();
    }
}
