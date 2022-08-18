package com.company.homework.HomeWork_Practice24.Task2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static Map<String, TranslateContainer> dictionary = new TreeMap<>();
    public static TreeMap<Integer, String> ratingTop10Popularity = new TreeMap<>(Collections.reverseOrder());

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        createTestValuesOfDictionary();

        try {
            Scanner inputFromConsole = new Scanner(System.in);
            printStartOperationDialog();

            outer:
            while (inputFromConsole.hasNextLine()) {
                String currentOperation = inputFromConsole.nextLine();
                MenuOfDictionary userChoice = MenuOfDictionary.getNumberMenu(currentOperation);
                if (userChoice == null) {
                    System.out.print("Operation not found!\n");
                    printStartOperationDialog();
                    continue;
                }
                switch (userChoice) {
                    case ADD_WORD_WITH_TRANSLATE -> addNewWordWithTranslate(inputFromConsole);
                    case REPLACE_WORD_WITH_TRANSLATE -> replaceWordWithTranslate(inputFromConsole);
                    case DELETE_WORD_WITH_TRANSLATE -> deleteWordWithTranslate(inputFromConsole);
                    case SHOW_WORD_AND_TRANSLATE -> showElementOfDictionary(inputFromConsole);
                    case ADD_TRANSLATE_TO_WORD -> addTranslateToExistWord(inputFromConsole);
                    case REPLACE_TRANSLATE_BY_WORD -> replaceTranslateByWord(inputFromConsole);
                    case DELETE_TRANSLATE_BY_WORD -> deleteTranslateByWord(inputFromConsole);
                    case SHOW_CURRENT_DICTIONARY -> showCurrentDictionary();
                    case SHOW_TOP10_POPULARITY -> showTop10Popularity();
                    case SHOW_TOP10_UNPOPULARITY -> showTop10Unpopularity();
                    case EXIT -> {
                        // Выход из диалога.
                        System.out.println("Good Bye!");
                        break outer;
                    }
                    default -> System.out.print("Value not supported.\n");
                }
                printStartOperationDialog();
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * FIXME Метод не доделан. Катастрофически не хватает времени. Не успеваю решать задачи. Очень отстал.
     */
    private static void showTop10Unpopularity() {
        if (ratingTop10Popularity.size() < 10) {
            System.out.println("There are no unpopular words in the top 10 ranking.");
        } else {
            System.out.print("Rating TOP 10 unpopular words. Word: - 'value', number of hits: - 'value'.\n");
            ArrayList<Integer> keys = new ArrayList<>(ratingTop10Popularity.keySet());
            for(int i = keys.size() - 1; i >= 0; i--){
                System.out.println(ratingTop10Popularity.get(keys.get(i)));
            }
        }
    }

    private static void showTop10Popularity() {
        System.out.print("Rating TOP 10 popular words. Word: - 'value', number of hits: - 'value'.\n");
        int count = 0;
        for (Map.Entry<Integer, String> currentValue : ratingTop10Popularity.entrySet()) {
            if (count > 9) {
                break;
            } else {
                System.out.println("Word: " + currentValue.getValue() + ", number of hits:" + currentValue.getKey());
            }
            count++;
        }
    }

    private static void recordRatingTop10Popularity(String wordKey) {
        if (ratingTop10Popularity.containsKey(dictionary.get(wordKey).getHitCounter())) {
            ratingTop10Popularity.remove(dictionary.get(wordKey).getHitCounter() - 1);
        } else {
            if (ratingTop10Popularity.containsValue(wordKey)) {
                ratingTop10Popularity.put(dictionary.get(wordKey).getHitCounter(), wordKey);
                ratingTop10Popularity.remove(dictionary.get(wordKey).getHitCounter() - 1);
            } else {
                ratingTop10Popularity.put(dictionary.get(wordKey).getHitCounter(), wordKey);
            }
        }
    }

    private static void showCurrentDictionary() {
        System.out.print("Current items in dictionary: \n");
        dictionary.entrySet().forEach(System.out::println);
        System.out.println();
    }

    private static void deleteTranslateByWord(Scanner inputFromConsole) {
        int ratingCounter;
        System.out.println("Enter the word where you want to remove the translation");
        String wordForRemoveTranslation = inputFromConsole.nextLine();
        ratingCounter = dictionary.get(wordForRemoveTranslation).getHitCounter();
        dictionary.remove(wordForRemoveTranslation);
        TreeSet<String> translate = new TreeSet<>();
        dictionary.put(wordForRemoveTranslation, new TranslateContainer(translate));
        dictionary.get(wordForRemoveTranslation).setHitCounter(ratingCounter);
        dictionary.get(wordForRemoveTranslation).setHitCounter(dictionary.get(wordForRemoveTranslation).getHitCounter() + 1);
        recordRatingTop10Popularity(wordForRemoveTranslation);
    }

    private static void replaceTranslateByWord(Scanner inputFromConsole) {
        System.out.print("Enter the word for which you want to change the translation: ");
        String wordForChangeTranslate = inputFromConsole.nextLine();
        if (checkExistWord(wordForChangeTranslate)) {
            System.out.print("Now the translation is like this:\n");
            showTranslateTheWord(wordForChangeTranslate);

            System.out.print("Enter the word do you want to change in translate: ");
            String wordForReplace = inputFromConsole.nextLine();
            addTranslateToWord(wordForChangeTranslate, inputFromConsole);

            dictionary.get(wordForChangeTranslate).getTranslate().remove(wordForReplace);
            dictionary.get(wordForChangeTranslate).setHitCounter(dictionary.get(wordForChangeTranslate).getHitCounter() + 1);
            recordRatingTop10Popularity(wordForChangeTranslate);
        } else {
            System.out.print("There is no such word in the dictionary. Select the desired action from the list.\n");
        }
    }

    private static void addTranslateToExistWord(Scanner inputFromConsole) {
        System.out.print("Enter the word to which you want to add a translation: ");
        String wordForAddTranslate = inputFromConsole.nextLine();
        if (checkExistWord(wordForAddTranslate)) {
            addTranslateToWord(wordForAddTranslate, inputFromConsole);
            dictionary.get(wordForAddTranslate).setHitCounter(dictionary.get(wordForAddTranslate).getHitCounter() + 1);
            recordRatingTop10Popularity(wordForAddTranslate);
        } else {
            System.out.print("There is no such word in the dictionary. Select the desired action from the list.\n");
        }
    }

    private static void showElementOfDictionary(Scanner inputFromConsole) {
        System.out.print("Enter the word to show the word with translate: ");
        String wordForShow = inputFromConsole.nextLine();
        if (checkExistWord(wordForShow)) {
            showTranslateTheWord(wordForShow);
            dictionary.get(wordForShow).setHitCounter(dictionary.get(wordForShow).getHitCounter() + 1);
            recordRatingTop10Popularity(wordForShow);
        } else {
            System.out.printf("There is no such word '%s' in the dictionary.\n", wordForShow);
        }
    }

    private static void showTranslateTheWord(String wordForShow) {
        String valueForShow = String.valueOf(dictionary.get(wordForShow));
        System.out.println("Word: " + wordForShow + ", translate: " + valueForShow.replaceAll("[\\[\\]]", ""));
    }

    private static void deleteWordWithTranslate(Scanner inputFromConsole) {
        System.out.print("Enter the word you want delete: ");
        String wordForDelete = inputFromConsole.nextLine();
        if (checkExistWord(wordForDelete)) {
            dictionary.remove(wordForDelete);
            System.out.printf("You have successfully deleted '%s' word.\n", wordForDelete);
        } else {
            System.out.printf("There is no such word '%s' in the dictionary.\n", wordForDelete);
        }

    }

    private static void replaceWordWithTranslate(Scanner inputFromConsole) {
        System.out.print("Enter the word in the dictionary you want to replace. : \n");
        String wordForReplace = inputFromConsole.nextLine();
        System.out.printf("Enter a new word to replace '%s': \n", wordForReplace);
        String newWord = inputFromConsole.nextLine();
        if (checkExistWord(newWord)) {
            System.out.print("This word exists in the dictionary. Select an action from main menu.\n");
        } else {
            addTranslateToWord(newWord, inputFromConsole);
            dictionary.remove(wordForReplace);
            System.out.printf("You have successfully replace the '%s' word.\n", wordForReplace);
        }
    }

    private static void addTranslateToWord(String wordInDictionary, Scanner inputFromConsole) {

        System.out.printf("Enter the translation of a word '%s' or several words of translation separated by a space: \n", wordInDictionary);
        String newTranslate = inputFromConsole.nextLine();
        String[] newTranslateArray = newTranslate.split(" ");

        if (dictionary.containsKey(wordInDictionary)) {
            Collections.addAll(dictionary.get(wordInDictionary).getTranslate(), newTranslateArray);
        } else {
            TreeSet<String> translate = new TreeSet<>();
            Collections.addAll(translate, newTranslateArray);
            TranslateContainer translateContainer = new TranslateContainer(translate);
            dictionary.put(wordInDictionary, translateContainer);
        }
    }

    private static void addNewWordWithTranslate(Scanner inputFromConsole) {
        System.out.print("Enter a word to add to the dictionary: \n");
        String newWord = inputFromConsole.nextLine();
        if (checkExistWord(newWord)) {
            System.out.print("This word exists in the dictionary. Select an action from main menu.\n");
        } else {
            addTranslateToWord(newWord, inputFromConsole);
            System.out.print("You have successfully added a new word to the dictionary.\n");
        }
    }

    private static boolean checkExistWord(String wordForCheck) {
        return dictionary.containsKey(wordForCheck);
    }

    private static void printStartOperationDialog() {
        System.out.print("Enter the number of the desired action: \n");
        System.out.println(getOperations());
        System.out.print("Your choice: ");
    }

    private static String getOperations() {
        return (Arrays.toString(MenuOfDictionary.values()).
                replace("[", "")).
                replace("]", "").
                replace(", ", "").
                trim();
    }

    private static void createTestValuesOfDictionary() {
        String word1 = "три";
        TreeSet<String> translate1 = new TreeSet<>();
        TranslateContainer translateContainer1 = new TranslateContainer(translate1);
        translate1.add("one");
        translate1.add("two");
        dictionary.put(word1, translateContainer1);

        String word2 = "раз";
        TreeSet<String> translate2 = new TreeSet<>();
        TranslateContainer translateContainer2 = new TranslateContainer(translate2);
        translate2.add("one");
        translate2.add("two");
        dictionary.put(word2, translateContainer2);

        String word3 = "два";
        TreeSet<String> translate3 = new TreeSet<>();
        TranslateContainer translateContainer3 = new TranslateContainer(translate3);
        translate3.add("one");
        translate3.add("two");
        dictionary.put(word3, translateContainer3);

        TreeSet<String> translate4 = new TreeSet<>();
        TranslateContainer translateContainer4 = new TranslateContainer(translate4);
        dictionary.put("четыре", translateContainer4);

        String word5 = "пять";
        TreeSet<String> translate5 = new TreeSet<>();
        TranslateContainer translateContainer5 = new TranslateContainer(translate5);
        translate5.add("one");
        translate5.add("two");
        dictionary.put(word5, translateContainer5);

        String word6 = "шесть";
        TreeSet<String> translate6 = new TreeSet<>();
        TranslateContainer translateContainer6 = new TranslateContainer(translate6);
        translate6.add("one");
        translate6.add("two");
        dictionary.put(word6, translateContainer6);
//        dictionary.get(word6).setHitCounter(dictionary.get(word6).getHitCounter() + 1);

    }
}
