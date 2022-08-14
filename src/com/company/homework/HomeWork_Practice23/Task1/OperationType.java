package com.company.homework.HomeWork_Practice23.Task1;

public enum OperationType {

    ADD ("1", ". Добавить элемент в список."),
    REMOVE ("2", ". Удалить элемент из списка."),
    SHOW ("3", ". Показать содержимое списка."),
    CONTAINS ("4", ". Проверить есть ли значение в списке."),
    REPLACE ("5", ". Заменить значение в списке."),
    EXIT ("6", ". Выход");

    private final String desc;
    private final String number;

    OperationType(String number, String desc) {
        this.number = number;
        this.desc = desc;

    }

    public String getDesc() {
        return desc;
    }

    public String getNumber() {
        return number;
    }

    public static OperationType getEnumByNumber(String number) {
        for (OperationType value : values()) {
            if (value.number.equals(number)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(desc);
        sb.append("\n");
        return sb.toString();
    }
}
