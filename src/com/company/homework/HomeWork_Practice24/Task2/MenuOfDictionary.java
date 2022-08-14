package com.company.homework.HomeWork_Practice24.Task2;

public enum MenuOfDictionary {

    ADD_WORD_WITH_TRANSLATE("1", ". Adding a word with translation."),
    REPLACE_WORD_WITH_TRANSLATE("2", ". Replacement a word with translation."),
    DELETE_WORD_WITH_TRANSLATE("3", ". Deleting a word with translation."),
    SHOW_WORD_AND_TRANSLATE("4", ". Show a word and its translation."),
    ADD_TRANSLATE_TO_WORD("5", ". Add a translation to an existing word."),
    REPLACE_TRANSLATE_BY_WORD("6", ". Replacing the translation of an existing word."),
    DELETE_TRANSLATE_BY_WORD("7", ". Deleting the translation of an existing word."),
    SHOW_CURRENT_DICTIONARY("8", ". Show all current items in dictionary."),
    SHOW_TOP10_POPULARITY("9", ". Show top 10 words"),
    SHOW_TOP10_UNPOPULARITY("10", ". Show 10 most unpopular words"),
    EXIT("11", ". Выход и завершение программы.");


    private final String numberMenu;
    private final String description;

    MenuOfDictionary(String numberMenu, String description) {
        this.numberMenu = numberMenu;
        this.description = description;
    }

    public static MenuOfDictionary getNumberMenu(String numberMenu) {
        for (MenuOfDictionary value : values()) {
            if (value.numberMenu.equals(numberMenu)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(numberMenu);
        sb.append(description);
        sb.append("\n");
        return sb.toString();
    }
}
