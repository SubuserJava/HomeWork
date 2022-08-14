package com.company.homework.HomeWork_Practice23.Task2;

public class User {

    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserList { ");
        sb.append("login = '").append(login).append('\'');
        sb.append(", password = '").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
