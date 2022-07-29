package com.company.homework.homework7_4;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Основной метод для проверки класса MyArrayList
 *
 * @author User
 * @version 1.0
 * @see System#setOut(PrintStream)
 */
public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        MyArrayList<String> myArrayList1 = new MyArrayList<>();

        myArrayList1.addElementToBack("Первый элемент (Array1)");
        myArrayList1.addElementToBack("Второй элемент (Array1)");
        System.out.println(myArrayList1);


        MyArrayList<String> clone = myArrayList1.clone();
        System.out.println(clone);

//        MyArrayList<String> myArrayList2 = new MyArrayList<>(2);
//        myArrayList2.addElementToBack("Первый элемент (Array2)");
//        myArrayList2.addElementToBack("Второй элемент (Array2)");
//        System.out.println(myArrayList2);

    }
}

