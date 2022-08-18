package com.company.homework.homework10;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;

public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = 3237287467131086986L;

    private final String EMAIL_ADDRESS;
    private String name;
    private String surname;
    private String nickName;
    private Year birthYear;
    private ArrayList<String> mobilePhoneNum;
    private ArrayList<String> homePhoneNum;
    private ArrayList<String> workPhoneNum;
    private ArrayList<String> faxPhoneNum;

    public Contact(String name, String surname, String nickName, String EMAIL_ADDRESS, Year birthYear, ArrayList<String> mobilePhoneNum,
                   ArrayList<String> homePhoneNum, ArrayList<String> workPhoneNum, ArrayList<String> faxPhoneNum) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
        this.birthYear = birthYear;
        this.mobilePhoneNum = mobilePhoneNum;
        this.homePhoneNum = homePhoneNum;
        this.workPhoneNum = workPhoneNum;
        this.faxPhoneNum = faxPhoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEMAIL_ADDRESS() {
        return EMAIL_ADDRESS;
    }

    public Year getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Year birthYear) {
        this.birthYear = birthYear;
    }

    public ArrayList<String> getMobilePhoneNum() {
        return mobilePhoneNum;
    }

    public void setMobilePhoneNum(ArrayList<String> mobilePhoneNum) {
        this.mobilePhoneNum = mobilePhoneNum;
    }

    public ArrayList<String> getHomePhoneNum() {
        return homePhoneNum;
    }

    public void setHomePhoneNum(ArrayList<String> homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public ArrayList<String> getWorkPhoneNum() { return workPhoneNum; }

    public void setWorkPhoneNum(ArrayList<String> workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
    }

    public ArrayList<String> getFaxPhoneNum() {
        return faxPhoneNum;
    }

    public void setFaxPhoneNum(ArrayList<String> faxPhoneNum) {
        this.faxPhoneNum = faxPhoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname) && Objects.equals(nickName, contact.nickName) &&
                Objects.equals(EMAIL_ADDRESS, contact.EMAIL_ADDRESS) && Objects.equals(birthYear, contact.birthYear) &&
                Objects.equals(mobilePhoneNum, contact.mobilePhoneNum) && Objects.equals(homePhoneNum, contact.homePhoneNum) &&
                Objects.equals(workPhoneNum, contact.workPhoneNum) && Objects.equals(faxPhoneNum, contact.faxPhoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nickName, EMAIL_ADDRESS, birthYear, mobilePhoneNum, homePhoneNum, workPhoneNum, faxPhoneNum);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", eMailAddress='").append(EMAIL_ADDRESS).append('\'');
        sb.append(", birthYear='").append(birthYear).append('\'');
        sb.append(", mobilePhoneNum=").append(mobilePhoneNum);
        sb.append(", homePhoneNum=").append(homePhoneNum);
        sb.append(", workPhoneNum=").append(workPhoneNum);
        sb.append(", faxPhoneNum=").append(faxPhoneNum);
        sb.append('}');
        return sb.toString();
    }
}
