package com.company.homework.homework4_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[][] figure1 = {
                {" ", "*", " "},
                {"*", " ", "*"},
                {" ", "*", " "}
        };

        String[][] figure2 = {
                {" ", "*", " "},
                {"*", " ", "*"},
                {" ", "*", " "}
        };

        System.out.println(figure1[2][1]);
        System.out.println(figure1[2].length);
        System.out.println();

        String[] nameArrays = {"figure1", "figure2"};

        String[][] figure3 = new String[figure1.length * 2][];

        String a = "figure";
        String b = "1";
        String c = a.concat(b);

        System.arraycopy(figure1, 0, figure3, 0, figure1.length);
        System.arraycopy(figure2, 0, figure3, figure1.length, figure2.length);

        System.out.println(Arrays.deepToString(figure1));
        System.out.println(Arrays.deepToString(figure3));
        System.out.println();
        System.out.println(figure3[0].length);


        for (int arrayCountLines = 0; arrayCountLines < figure3[0].length; arrayCountLines++) {
            for (int countPrintLines = arrayCountLines; countPrintLines < figure3.length; countPrintLines += 3) {
                System.out.print(Arrays.deepToString(figure3[countPrintLines]).replaceAll("\\[|\\]|\\,\\s", ""));
            }
            System.out.println();
        }
    }
}
