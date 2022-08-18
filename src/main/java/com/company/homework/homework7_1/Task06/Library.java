package com.company.homework.homework7_1.Task06;

public class Library {

    private int cardNum;
    private String fio;
    private int groupNum;

    private String nameAuthorOfBook;
    private String dateOfLend;
    private String dateOfReturn;
    private int limitDay;

    public String toStringData(String arg) {   // печать базы или книг или студентов.
        if (arg == "book") {
            return "Library{" +
                    "cardNum=" + cardNum +
                    ", nameAuthorOfBook='" + nameAuthorOfBook + '\'' +
                    ", dateOfIssued='" + dateOfLend + '\'' +
                    ", limitDay=" + limitDay +
                    '}';
        } else {
            return "Library{" +
                    "cardNum=" + cardNum +
                    ", fio='" + fio + '\'' +
                    ", groupNum=" + groupNum +
                    '}';
        }
    }

    public Library(int cardNum, String fio, int groupNum) {
        this.cardNum = cardNum;
        this.fio = fio;
        this.groupNum = groupNum;
    }

    public Library(int cardNum, String nameAuthorOfBook, String dateOfLend, int limitDay, String dateOfReturn) {
        this.cardNum = cardNum;
        this.nameAuthorOfBook = nameAuthorOfBook;
        this.dateOfLend = dateOfLend;
        this.limitDay = limitDay;
        this.dateOfReturn = dateOfReturn;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public String getNameAuthorOfBook() {
        return nameAuthorOfBook;
    }

    public void setNameAuthorOfBook(String nameAuthorOfBook) {
        this.nameAuthorOfBook = nameAuthorOfBook;
    }

    public String getDateOfLend() {
        return dateOfLend;
    }

    public void setDateOfLend(String dateOfLend) {
        this.dateOfLend = dateOfLend;
    }

    public int getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(int limitDay) {
        this.limitDay = limitDay;
    }

}
