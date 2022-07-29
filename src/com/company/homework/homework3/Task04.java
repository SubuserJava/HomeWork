package com.company.homework.homework3;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);                    // Ввод координат точки
        System.out.print("Enter x and y coordinates in the range -10 to 10 for each axis .\n" +
                "coordinate x - ");
        float coordinateX = consoleSystemIn.nextFloat();
        System.out.print("coordinate y - ");
        float coordinateY = consoleSystemIn.nextFloat();

        if (coordinateX == 0 & coordinateY == 0) {                 // Выявление четверти в декартовой системе координат.
            System.out.println("Your point does not belong to any quarter. It belongs to all quarters.");
        } else if ((coordinateX > 0) & (coordinateX < 10) & (coordinateY > 0) & (coordinateY < 10)) {
            System.out.println("Your point belongs to the I quarter.");
        } else if ((coordinateX > 0) & (coordinateX < 10) & (coordinateY < 0) & (coordinateY > -10)) {
            System.out.println("Your point belongs to the IV quarter.");
        } else if ((coordinateX < 0) & (coordinateX > -10) & (coordinateY > 0) & (coordinateY < 10)) {
            System.out.println("Your point belongs to the II quarter.");
        } else if ((coordinateX < 0) & (coordinateX > -10) & (coordinateY < 0) & (coordinateY > -10)) {
            System.out.println("Your point belongs to the III quarter.");
        } else {
            System.out.println("Any of the coordinates is out of the given range.");
        }
    }
}
