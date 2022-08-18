package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter any word. It will be determined whether the word belongs to the MumbaJumba language");
        String wordFromConsole = consoleInput.nextLine();

        if (wordFromConsole.matches(".*b{2}.*|.*a{3}.*|.*b{3}.*|.*c{3}.*|.*(ab){3}.*|.*(bc){3}.*|.*(ac){3}.*|" +
                ".*(abc){3}.*|.*(acb){3}.*|.*(bac){3}.*|.*(bca){3}.*|.*(cab){3}.*|.*(cba){3}.*")) {
            System.out.println("The word not belong to the MumbaJumba language.");
        } else {
            System.out.println("The word belong to the MumbaJumba language.");       // Если не одно условие не подошло, слово подходит к языку.
        }
    }
}


