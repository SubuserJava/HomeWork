package com.company.homework.homework7_1.Task06;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    /* **/
    public static void main(String[] args) {           // Сделано без всевозвможных проверок ввода.

        Scanner consoleInput = new Scanner(System.in);

        // Уже имеющиеся студенты. Размер массива взят условно.
        Library[] students = new Library[100];
        students[0] = new Library(123456, "Ivanov Ivan Ivanovich", 54);
        students[1] = new Library(123457, "Petrov Petr Petrovich", 55);
        students[2] = new Library(123458, "Sidorov Alexey Sidorovich", 56);
        students[3] = new Library(123459, "Fedorov Anatoliy Fedorovich", 56);
        // Уже выданные книги. Размер массива взят условно.
        Library[] lendBooks = new Library[1000];
        lendBooks[0] = new Library(123456, "'Enter' Ivanov I.I.", "2022-01-20", 20, "2022-01-25");
        lendBooks[1] = new Library(123457, "'Exit' Petrov P.P.", "2022-02-12", 20, "");
        lendBooks[2] = new Library(123458, "'Fly' Gaev D.V.", "2022-06-05", 20, "");

        System.out.println("Now students in base:");    // Печать массива по студентам.
        for (Library stud : students) {
            if (stud == null) {
            } else {
                System.out.println(stud.toStringData("student"));   // Вызов метода печати элементов массива по студентам.
            }
        }
        System.out.println();

        // Цикл внесение нового студента в базу.
        for (; ; ) {
            System.out.print("if you want to add a new student, enter \"yes\" if yes, otherwise enter \"no\".\nYour choice: ");
            String yesNo = consoleInput.nextLine();
            if (yesNo.equals("no")) {
                System.out.println();
                break;
            } else {
                inputNewStudentData(consoleInput, students);      // Вызов метода внесения нового студента в базу.
                System.out.println();
            }

        }


        System.out.println("Now books lend:");   // Печать массива по книгам
        for (Library books : lendBooks) {
            if (books == null) {
            } else {
                System.out.println(books.toStringData("book"));  // Вызов метода печати элементов массива по книгам.
            }
        }
        System.out.println();

        // Цикл выдача книг.
        for (; ; ) {
            System.out.print("Do you want to to lend a book to a student? Enter \"yes\" if yes, otherwise enter \"no\".\nYour choice: ");
            String yesNo = consoleInput.nextLine();
            if (yesNo.equals("no")) {
                System.out.println();
                break;
            } else {
                lendBooks(consoleInput, lendBooks);       // Вызов метода выдачи книг
                System.out.println();
            }

        }

        // Проверка выданных книг
        System.out.print("If you want to check the lend books, type 'yes'. If not, type 'no'.\nYour choice: ");
        String yesNo = consoleInput.nextLine();
        if (yesNo.equals("yes")) {
            verificationOfDebtors(lendBooks);
            System.out.print("if you have found a debtor and want to know the last name, first name and patronymic," +
                    " enter the debtor's card number.\nCard number of debtor: ");
            int cardNumDebtors = Integer.parseInt(consoleInput.nextLine());
            getFioDebtor(cardNumDebtors, students);
        }
    }


    // Check books array.
//        System.out.println("Now books lend:");
//        for (Library books : lendBooks) {
//            if (booksLend == null) {
//            } else {
//                System.out.println(books.toStringData("book"));
//            }
//        }


    // Check students array.
//        System.out.println("Now students in base:");
//        for (Library student : students) {
//            if (stud == null) {
//            } else {
//                System.out.println(stud.toStringData("students"));
//            }
//        }

    /*
    Методы
    */
    // Метод внесения данных нового студента.
    private static void inputNewStudentData(Scanner consoleInput, Library[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] == null) {
                System.out.print("Enter new student data card number, fio, group number.\nInput next card number after " + students[i - 1].getCardNum() + ": ");
                break;
            }
        }
        int newStudentCard = Integer.parseInt(consoleInput.nextLine());
        System.out.print("FIO: ");
        String newStudentFio = consoleInput.nextLine();
        System.out.print("Group number: ");
        int newGroupNum = Integer.parseInt(consoleInput.nextLine());
        for (int i = 0; i < students.length - 1; ++i) {
            if (students[i] == null) {
                students[i] = new Library(newStudentCard, newStudentFio, newGroupNum);
                break;
            }
        }
    }

    // Метод выдачи книг.
    private static void lendBooks(Scanner consoleInput, Library[] lendBooks) {
        System.out.print("Enter new data of lend book: card number, name book and author, date of lend (format: yyyy-mm-dd) and limit days.\nYour input card number: ");
        int newBookCardNum = Integer.parseInt(consoleInput.nextLine());
        System.out.print("Name book and author: ");
        String newBookNameAndAuthor = consoleInput.nextLine();
        System.out.print("Date of lend: ");
        String newBookDateLend = consoleInput.nextLine();
        System.out.print("Amount of limit days: ");
        int newBookLimitDays = Integer.parseInt(consoleInput.nextLine());
        String newBookReturnDay = "";
        for (int i = 0; i < lendBooks.length; ++i) {
            if (lendBooks[i] == null) {
                lendBooks[i] = new Library(newBookCardNum, newBookNameAndAuthor, newBookDateLend, newBookLimitDays, newBookReturnDay);
                break;
            }
        }
    }

    // Метод проверки должников.
    private static void verificationOfDebtors(Library[] lendBooks) {
        for (Library lendBook : lendBooks) {
            if (lendBook != null) {                                             // Проходимся по массиву с данными. Если пустое поле (это конец данных в масссиве) - выход.
                if (lendBook.getDateOfReturn() == "") {                         // Если поле даты возврата пустое - проверка.
                    String dateBookLendField = lendBook.getDateOfLend();               // "Вытаскиваем" строку с датой.
                    LocalDate dateBookReturn = LocalDate.parse(dateBookLendField);     // Дату - во временную переменную для манипуляций.
                    dateBookReturn = dateBookReturn.plusDays(lendBook.getLimitDay());  // Прибавление к дате выдачи книги лимита по дням.
                    if (dateBookReturn.isEqual(LocalDate.now())) {                     // Проверяем на текущую дату.
                        System.out.println("Library card number: " + lendBook.getCardNum());
                        System.out.println("Date of lend " + dateBookReturn + " is equal to date now (" + LocalDate.now() + "). The book must be submitted by tomorrow.");
                    } else if (dateBookReturn.isBefore(LocalDate.now())) {
                        System.out.println("Library card number: " + lendBook.getCardNum());      // Выявление должника и показ номера билета должника.
                        System.out.println("Book return expired!");
                    } else if (dateBookReturn.isAfter(LocalDate.now())) {
                        System.out.println("The book" + lendBook.getNameAuthorOfBook() + " not return, but the withdrawal limit has not been exceeded.\n" +
                                "Card number: " + lendBook.getCardNum() + "Date of return: " + dateBookReturn);
                    } else {
                        System.out.println("How to get here?"); // Что то пошло не так...
                    }
                }
            } else {
                System.out.println();
                return;
            }
        }
    }

    // Метод получения ФИО и номера группы должника.
    private static void getFioDebtor(int cardNumDebtors, Library[] students) {
        for (Library student : students) {
            if (student == null) {                // Если конец данных в массиве - выход
                break;
            }
            if (cardNumDebtors == student.getCardNum()) {
                System.out.println("Name of debtor is: " + student.getFio() + "Group number: " + student.getGroupNum());
            }
        }
    }
}
