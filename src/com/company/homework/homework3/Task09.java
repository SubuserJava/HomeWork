package com.company.homework.homework3;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in); // Ввод координат с условием начала (x, y) и конца (x1, y1) отрезка.
        System.out.print("""
                Enter the coordinates of the segment (x, y - coordinates of start segment,
                x1, y1 - coordinates of end segment).
                x -\s""");
        float coordinateX = console.nextFloat();
        System.out.print("y - ");
        float coordinateY = console.nextFloat();
        System.out.print("x1 - ");
        float coordinateX1 = console.nextFloat();
        System.out.print("y1 - ");
        float coordinateY1 = console.nextFloat();

        if (coordinateX1 > coordinateX & coordinateY1 > coordinateY) { // Условие для типа отрезка "горка".
            System.out.println("The segment is rise.");
        } else if (coordinateX1 > coordinateX & coordinateY1 < coordinateY) { // Условие для типа отрезка "спуск".
            System.out.println("The segment is descent.");
        } else if (coordinateX < coordinateX1 & coordinateY == coordinateY1) { // Условие для типа отрезка "горизонталь".
            System.out.println("The segment is horizontal.");
        } else if (coordinateX == coordinateX1 & coordinateY < coordinateY1) { // Условие для типа отрезка "вертикаль".
            System.out.println("The segment is vertical.");
        } else {
            System.out.println("This coordinates outside the measuring range!");
        }
    }
}
