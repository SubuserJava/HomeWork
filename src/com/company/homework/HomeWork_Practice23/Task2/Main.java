package com.company.homework.HomeWork_Practice23.Task2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        LinkedList<User> usersList = new LinkedList<>();
        Scanner consoleInput = new Scanner(System.in);
        usersList.add(new User("user1", "Password"));
        usersList.add(new User("user2", "Password"));
        usersList.add(new User("user3", "Password"));
        usersList.forEach(System.out::println);

        printStartOperationDialog();

        outer:
        while (consoleInput.hasNextLine()) {
            String currentOperation = consoleInput.nextLine();
            OperationTypeUser enumByUser = OperationTypeUser.getEnumByUser(currentOperation);
            if (enumByUser == null) {
                System.out.print("Operation not found!\n");
                printStartOperationDialog();
                continue;
            }
            switch (enumByUser) {
                case ADD_USER -> addNewUserLoginPassword(usersList, consoleInput);
                case DELETE_USER -> deleteUserLoginPassword(usersList, consoleInput);
                case CONTAINS_USER -> containsUserLogin(usersList, consoleInput);
                case CHANGE_LOGIN -> changeUserLogin(usersList, consoleInput);
                case CHANGE_PASSWORD -> changeUserPassword(usersList, consoleInput);
                case EXIT -> {
                    System.out.println("Good Bye!");
                    // Выход из диалога.
                    break outer;
                }
                default -> System.out.print("Value not supported.\n");
            }
            // Проверочная печать базы логинов/паролей.
//            System.out.println(usersList + "\n");
            printStartOperationDialog();
        }
        consoleInput.close();
    }

    private static void containsUserLogin(LinkedList<User> usersList, Scanner consoleInput) {
        System.out.print("Enter user login for verify existing login.\nLogin: ");
        String loginForCheckExist = consoleInput.nextLine().toLowerCase();
        if (getCheckForContainsLogin(usersList, loginForCheckExist)) {
            System.out.printf("The list contains user login '%s'.\n", loginForCheckExist);
        } else {
            System.out.print("There is no such user in the list.\n");
        }
    }

    /**
     * Смена пароля пользователя. Новое назначения поля password экземпляра класса User.
     *
     * @param usersList    база логин/пароль
     * @param consoleInput Сканер
     */
    private static void changeUserPassword(LinkedList<User> usersList, Scanner consoleInput) {
        System.out.print("Enter the user login you would like to change password: ");
        String userLogin = consoleInput.nextLine().toLowerCase();
        for (User currentUser : usersList) {
            if (currentUser.getLogin().equals(userLogin)) {
                System.out.printf("Enter new password for user login '%s': ", userLogin);
                String newUserPassword = consoleInput.nextLine();
                currentUser.setPassword(newUserPassword);
                System.out.print("Password was change successfully.\n");
                break;
            }
        }
    }

    /**
     * Смена логина пользователя. Новое назначения поля login экземпляра класса User.
     *
     * @param usersList    база логин/пароль
     * @param consoleInput Сканер
     */
    private static void changeUserLogin(LinkedList<User> usersList, Scanner consoleInput) {
        System.out.print("Enter the user login you would like to change: ");
        String userLogin = consoleInput.nextLine().toLowerCase();
        for (User currentUser : usersList) {
            if (currentUser.getLogin().equals(userLogin)) {
                System.out.printf("Enter new login for user login '%s': ", userLogin);
                String newUserLogin = consoleInput.nextLine().toLowerCase();
                currentUser.setLogin(newUserLogin);
                System.out.print("Login was change successfully.\n");
                break;
            }
        }
    }

    /**
     * Отдельная проверка (без диалогов и сообщений) на свопадение введённого логина.
     *
     * @param usersList          база логин/пароль
     * @param loginForCheckExist логин для проверки
     * @return результат проверки на совпадение
     */
    private static boolean getCheckForContainsLogin(LinkedList<User> usersList, String loginForCheckExist) {
        for (User currentUser : usersList) {
            if (currentUser.getLogin().equals(loginForCheckExist)) {
                return true;
            }
        }
        return false;
    }

    private static void deleteUserLoginPassword(LinkedList<User> usersList, Scanner consoleInput) {
        System.out.print("Enter login of the user you want to delete.\nLogin: ");
        String userLogin = consoleInput.nextLine().toLowerCase();
        usersList.removeIf(currentUser -> currentUser.getLogin().equals(userLogin));
        System.out.printf("User with login %s was remove from base successfully.\n", userLogin);
    }

    /**
     * Добавление нового пользователя с проверкой на уникальность логина пользователя. При выявлении совпадения,
     * предлагается придумать новый логин. Проверка по паролю не производится.
     *
     * @param usersList    база логин/пароль
     * @param consoleInput Сканер
     */
    private static void addNewUserLoginPassword(LinkedList<User> usersList, Scanner consoleInput) {
        System.out.print("Enter a new username and password to add to the base.\n" +
                "Type 'exit' to exit input mode.\n");
        System.out.print("Login: ");
        while (consoleInput.hasNext()) {
            String userLogin = consoleInput.nextLine().toLowerCase();
            if (userLogin.equals("exit")) {
                System.out.println("You finished entering numbers.");
                break;
            } else if (getCheckForContainsLogin(usersList, userLogin)) {
                System.out.print("Your entered login exist in list of user base.\nPlease, create new login.\n");
            } else {
                System.out.print("Password: ");
                String userPassword = consoleInput.nextLine();
                usersList.add(new User(userLogin, userPassword));
            }
            System.out.print("Login: ");
        }
    }

    private static void printStartOperationDialog() {
        System.out.print("Enter the number of the desired action: \n");
        System.out.println(getOperations());
        System.out.print("Your choice: ");
    }

    private static String getOperations() {
        return (Arrays.toString(OperationTypeUser.values()).
                replace("[", "")).
                replace("]", "").
                replace(", ", "").
                trim();
    }

}
