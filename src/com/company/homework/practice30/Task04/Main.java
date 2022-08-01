package com.company.homework.practice30.Task04;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final List<Television> televisionArrayList = new ArrayList<>();

    public static void main(String[] args) {

        fillTVsList();
        System.out.print("All list set of TVs:\n");
        televisionArrayList
                .forEach(System.out::println);
        System.out.println("----");
        System.out.print("TVs list with diagonal 50':\n");
        televisionArrayList.stream()
                .filter(television -> television.getScreenDiagonal().equals("50'"))
                .forEach(System.out::println);
        System.out.println("----");
        System.out.print("'AOC' TVs list:\n");
        televisionArrayList.stream()
                .filter(television -> television.getManufacturer().equals("AOC"))
                .forEach(System.out::println);
        System.out.println("----");
        System.out.print("TVs list more expensive 100000:\n");
        televisionArrayList.stream()
                .filter(television -> television.getPrice() > 130_000L)
                .forEach(System.out::println);
        System.out.println("----");
        System.out.print("TVs list sorted by price ascending.\n");
        televisionArrayList.stream()
                .sorted(Comparator.comparingLong(Television::getPrice))
                .forEach(System.out::println);
        System.out.println("----");
        System.out.print("TVs list sorted in descending order of price:\n");
        televisionArrayList.stream()
                .sorted(Comparator.comparingLong(Television::getPrice).reversed())
                .forEach(System.out::println);
    }

    private static void fillTVsList() {
        televisionArrayList.add(new Television("KDL-50", Year.parse("2005"), 150_000L, "50'", "Sony"));
        televisionArrayList.add(new Television("KDL-60", Year.parse("2008"), 200_000L, "60'", "Sony"));
        televisionArrayList.add(new Television("ABC-40", Year.parse("2010"), 130_000L, "40'", "Toshiba"));
        televisionArrayList.add(new Television("ABC-50", Year.parse("2012"), 160_000L, "50'", "Toshiba"));
        televisionArrayList.add(new Television("DEF_100", Year.parse("2018"), 50_000L, "30'", "AOC"));
        televisionArrayList.add(new Television("DEF-200", Year.parse("2018"), 80_000L, "40'", "AOC"));
        televisionArrayList.add(new Television("GHI-5", Year.parse("2022"), 250_000L, "40'", "Panasonic"));
        televisionArrayList.add(new Television("GHI-5", Year.parse("2022"), 290_000L, "60'", "Panasonic"));
    }
}
