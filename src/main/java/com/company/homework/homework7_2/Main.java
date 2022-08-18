package com.company.homework.homework7_2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner consoleInput = new Scanner(System.in);
        PaymentsRateByDay[] employeeRateByDayArray = new PaymentsRateByDay[100];        // База с работниками оплаты по ставке.
        PaymentsRateByHours[] employeeRateByHoursArray = new PaymentsRateByHours[100];  // База с работниками оплаты по часам.
        PaymentsRateByWorks[] employeeRateByWorksArray = new PaymentsRateByWorks[100];  // База с работниками оплаты по сдельным работам.

        // Существующие сотрудники с окладом.
        employeeRateByDayArray[0] = new PaymentsRateByDay("Ivanov I.I.", "By day", 300.58d, 20.0d);
        employeeRateByDayArray[1] = new PaymentsRateByDay("Petrov P.P.", "By day", 400.45d, 20.0d);
        // Сотрудники с почасовой оплатой.
        employeeRateByHoursArray[0] = new PaymentsRateByHours("Sidorov S.S.", "By hours", 34.85d, 150.0d);
        employeeRateByHoursArray[1] = new PaymentsRateByHours("Alexeev A.A.", "By hours", 30.94d, 150.0d);
        // Сотрудники со сдельной оплатой.
        employeeRateByWorksArray[0] = new PaymentsRateByWorks("Agafonov A.A.", "By works", 100.75d, 10.0d,
                200.85d, 20.0d);
        employeeRateByWorksArray[1] = new PaymentsRateByWorks("Potapov P.P.", "By works", 100.75d, 15.0d,
                200.85d, 25.0d);

        // Можно распечатать в простом виде все поля баз для наглядности.
//        printAllBases(employeeRateByDayArray, employeeRateByHoursArray, employeeRateByWorksArray);

        // Бесконечный цикл для диалога с выходом по набранной 4-ке.
        while (true) {
            System.out.print("""
                    Indicate what you want to do.
                    1. Print employee base
                    2. Enter the details of the new employee
                    3. Print a financial report of existing employees in the database
                    4. Exit
                    Your choice:\s""");
            int enteredNum = Integer.parseInt(consoleInput.nextLine());
            if (enteredNum == 4) {
                System.out.println("Good Bay!");
                break;
            }
            switch (enteredNum) {
                case 1 -> printAllEmployee(employeeRateByDayArray, employeeRateByHoursArray, employeeRateByWorksArray);               // Печать в простом виде полей экземпляра класса.
                case 2 -> inputNewEmployee(consoleInput, employeeRateByDayArray, employeeRateByHoursArray, employeeRateByWorksArray); // Ввод нового сотрудника.
                case 3 -> printTotalFinancialCalc(employeeRateByDayArray, employeeRateByHoursArray, employeeRateByWorksArray);        // Калькуляция и печать конечного отчета.
            }
        }
    }

    /**
     * Метод подсчёта и печати. Окончательный финансовый отчёт.
     */
    private static void printTotalFinancialCalc(PaymentsRateByDay[] employeeRateByDayArray, PaymentsRateByHours[] employeeRateByHoursArray,
                                                PaymentsRateByWorks[] employeeRateByWorksArray) {
        System.out.print("+------------------+-------------+-------------+\n");
        System.out.printf("%-18s %-13s %-12s", "|Name", "|Type of rate", "|Amount to pay|\n");
        System.out.print("+------------------+-------------+-------------+\n");
        for (PaymentsRateByDay elementOfArray : employeeRateByDayArray) {
            if (elementOfArray == null) {
                break;
            }
            System.out.printf("|%-18s|%-13s|%-13s|\n", elementOfArray.getFio(), elementOfArray.paymentMethod,
                    PaymentCalc.calcEmployeeRateByDay(elementOfArray.getRateByDay(), elementOfArray.getCountOfDays()));
            System.out.print("+------------------+-------------+-------------+\n");
        }
        for (PaymentsRateByHours elementOfArray : employeeRateByHoursArray) {
            if (elementOfArray == null) {
                break;
            }
            System.out.printf("|%-18s|%-13s|%-13s|\n", elementOfArray.getFio(), elementOfArray.paymentMethod,
                    PaymentCalc.calcEmployeeRateByHour(elementOfArray.getRateByHour(), elementOfArray.getNumberOfHour()));
            System.out.print("+------------------+-------------+-------------+\n");
        }
        for (PaymentsRateByWorks elementOfArray : employeeRateByWorksArray) {
            if (elementOfArray == null) {
                break;
            }
            System.out.printf("|%-18s|%-13s|%-13s|\n", elementOfArray.getFio(), elementOfArray.paymentMethod,
                    PaymentCalc.calcEmployeeRateByWork(elementOfArray.getRateTypeOfWork1(), elementOfArray.getNumberTypeOfWork1(),
                            elementOfArray.getRateTypeOfWork2(), elementOfArray.getNumberTypeOfWork2()));
            System.out.print("+------------------+-------------+-------------+\n");
        }
    }

    /**
     * Ввод новых работников в разные базы.
     */
    private static void inputNewEmployee(Scanner consoleInput, PaymentsRateByDay[] employeeRateByDayArray,
                                         PaymentsRateByHours[] employeeRateByHoursArray, PaymentsRateByWorks[] employeeRateByWorksArray) {
        System.out.print("Enter the details of the new employee.\nFIO (example, Ivanov I.I.): ");
        String fio = consoleInput.nextLine();
        System.out.print("Enter type of rate ('By day', 'By hours', 'By works':");
        String typeOfRate = consoleInput.nextLine();
        switch (typeOfRate) {
            case "By day" -> {
                System.out.print("Enter the employee's rate (example 15.15): ");
                double employeeRate = Double.parseDouble(consoleInput.nextLine());
                System.out.print("Enter the number of days worked by the employee: ");
                double employeeNumOfDay = Double.parseDouble(consoleInput.nextLine());
                for (int i = 0; i < employeeRateByDayArray.length - 1; i++) {
                    if (employeeRateByDayArray[i] == null) {
                        employeeRateByDayArray[i] = new PaymentsRateByDay(fio, typeOfRate, employeeRate, employeeNumOfDay);
                        break;
                    }

                }
            }
            case "By hours" -> {
                System.out.print("Enter the employee's rate by hours (example 15.15): ");
                double employeeRate = Double.parseDouble(consoleInput.nextLine());
                System.out.print("Enter the number of hours worked by the employee: ");
                double employeeNumOfHours = Double.parseDouble(consoleInput.nextLine());
                for (int i = 0; i < employeeRateByHoursArray.length; i++) {
                    if (employeeRateByHoursArray[i] == null) {
                        employeeRateByHoursArray[i] = new PaymentsRateByHours(fio, typeOfRate, employeeRate, employeeNumOfHours);
                        break;
                    }
                }
            }
            case "By works" -> {
                System.out.print("Enter the employee's rate for type of work 1 (example 15.15): ");
                double employeeRateTypeOfWork1 = Double.parseDouble(consoleInput.nextLine());
                System.out.print("Enter the number of hours worked by the employee by type of work 1: ");
                double employeeNumTypeOfWork1 = Double.parseDouble(consoleInput.nextLine());
                System.out.print("Enter the employee's rate for type of work 2 (example 15.15): ");
                double employeeRateTypeOfWork2 = Double.parseDouble(consoleInput.nextLine());
                System.out.print("Enter the number of hours worked by the employee by type of work 2: ");
                double employeeNumTypeOfWork2 = Double.parseDouble(consoleInput.nextLine());
                for (int i = 0; i < employeeRateByWorksArray.length; i++) {
                    if (employeeRateByWorksArray[i] == null) {
                        employeeRateByWorksArray[i] = new PaymentsRateByWorks(fio, typeOfRate, employeeRateTypeOfWork1, employeeNumTypeOfWork1,
                                employeeRateTypeOfWork2, employeeNumTypeOfWork2);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Печать всех работников в таблице.
     */
    private static void printAllEmployee(PaymentsRateByDay[] employeeRateByDayArray, PaymentsRateByHours[] employeeRateByHoursArray,
                                         PaymentsRateByWorks[] employeeRateByWorksArray) {
        System.out.println("Now in the base of employee.");
        System.out.print("+------------------+-------------+\n");
        System.out.printf("%-18s %-14s", "|Name", "|Type of rate |\n");
        System.out.print("+------------------+-------------+\n");
        for (PaymentsRateByDay employee : employeeRateByDayArray) {
            if (employee == null) {
                break;
            } else {
                System.out.printf("|%-18s|%-13s|\n", employee.getFio(), employee.paymentMethod);
                System.out.print("+------------------+-------------+\n");
            }
        }
        for (PaymentsRateByHours employee : employeeRateByHoursArray) {
            if (employee == null) {
                break;
            } else {
                System.out.printf("|%-18s|%-13s|\n", employee.getFio(), employee.paymentMethod);
                System.out.print("+------------------+-------------+\n");
            }
        }
        for (PaymentsRateByWorks employee : employeeRateByWorksArray) {
            if (employee == null) {
                break;
            } else {
                System.out.printf("|%-18s|%-13s|\n", employee.getFio(), employee.paymentMethod);
                System.out.print("+------------------+-------------+\n");
            }
        }
    }

    /**
     * Печать баз в простом виде. Обращение к методам toString из каждого класса.
     */
    private static void printAllBases(Employee[] employeeRateByDayArray, Employee[] employeeRateByHoursArray, Employee[] employeeRateByWorksArray) {
        for (Employee employee : employeeRateByDayArray) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }

        for (Employee employee : employeeRateByHoursArray) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }

        for (Employee employee : employeeRateByWorksArray) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }
    }
}


