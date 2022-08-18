package com.company.homework.HomeWork_Practice23.Task1;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        List<Double> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        fillNumberList(numberList, scanner);

        printStartOperationDialog();
        outer:
        while (scanner.hasNextLine()) {
            String currentOperation = scanner.nextLine();
            OperationType enumByNumber = OperationType.getEnumByNumber(currentOperation);
            if (enumByNumber == null) {
                System.out.print("Operation not found!\n");
                printStartOperationDialog();
                continue;
            }
            switch (enumByNumber) {
                case ADD -> addOperation(numberList, scanner);
                case REMOVE -> removeOperation(numberList, scanner);
                case SHOW -> System.out.println("Elements of the list: \n" + numberList);
                case CONTAINS -> containsOperation(numberList, scanner);
                case REPLACE -> replaceOperation(scanner, numberList);
                case EXIT -> {
                    break outer;
                }
                default -> System.out.println("Number of action is wrong!");
            }
            printStartOperationDialog();
        }
        scanner.close();
    }

    private static void replaceOperation(Scanner scanner, List<Double> numberList) {
        System.out.print("Enter value of element to replace: ");
        String numberToReplace = scanner.nextLine();
        System.out.print("Enter, please, which element from the list you want to replace: ");
        String indexOfElementToReplace = scanner.nextLine();
        numberList.set(Integer.parseInt(indexOfElementToReplace) - 1, Double.valueOf(numberToReplace));
    }

    private static void containsOperation(List<Double> numberList, Scanner scanner) {
        System.out.print("Enter value of element to check for existence: ");
        String findNumber = scanner.nextLine();
        if (numberList.contains(Double.valueOf(findNumber))) {
            System.out.printf("The list contains %s element.\n", findNumber);
        } else {
            System.out.printf("The list of the elements have not contains %s element.\n", findNumber);
        }
    }

    private static void removeOperation(List<Double> numberList, Scanner scanner) {
        System.out.print("Enter value of element for delete: ");
        String deleteElement = scanner.nextLine();
        numberList.remove(Double.valueOf(deleteElement));
        System.out.printf("Element %s delete successfully.\n", deleteElement);
    }

    private static void addOperation(List<Double> numberList, Scanner scanner) {
        System.out.print("Enter number for adding: ");
        String newNumber = scanner.nextLine();
        numberList.add(Double.valueOf(newNumber));
        System.out.printf("Element %s added successfully.\n", newNumber);
    }

    private static void printStartOperationDialog() {
        System.out.print("Enter the number of the desired action: \n");
        System.out.println(getOperations());
        System.out.print("Your choice: ");
    }

    private static void fillNumberList(List<Double> numberList, Scanner scanner) {
        System.out.print("Enter numbers using the 'enter' key.\n" +
                "Type 'exit' and press 'enter' if finished entering numbers.\n");
        System.out.print("Number: ");
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            if (currentLine.equals("exit")) {
                System.out.println("You finished entering numbers.");
                break;
            }
            System.out.print("Number: ");
            numberList.add(Double.valueOf(currentLine));
        }
    }

    private static String getOperations() {
        return (Arrays.toString(OperationType.values()).
                replace("[", "")).
                replace("]", "").
                replace(", ", "").
                trim();
    }
}
