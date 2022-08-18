package com.company.homework.HomeWork_Practice23.Task2;

public enum OperationTypeUser {

    ADD_USER("1", ". Добавление нового пользователя."),
    DELETE_USER("2", ". Удаление существующего пользователя."),
    CONTAINS_USER("3", ". Проверка существования пользователя в списке."),
    CHANGE_LOGIN("4", ". Изменение логина пользователя."),
    CHANGE_PASSWORD("5", ". Изменение пароля существующего пользователя."),
    EXIT("6", ". Выход и завершение программы.");

    private final String desc;
    private final String number;

    OperationTypeUser(String number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getNumber() {
        return number;
    }

    public static OperationTypeUser getEnumByUser(String number) {
        for (OperationTypeUser value : values()) {
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
