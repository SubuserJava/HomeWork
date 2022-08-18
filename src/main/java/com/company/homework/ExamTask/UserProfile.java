package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class UserProfile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1207569893714662743L;

    private String userFIO;
    private LocalDate userDateOfBirth;
    private String userTelephoneNumber;

    public UserProfile(String userFIO, LocalDate userDateOfBirth, String userTelephoneNumber) {
        this.userFIO = userFIO;
        this.userDateOfBirth = userDateOfBirth;
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public String getUserFIO() {
        return userFIO;
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public String getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(String userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userFIO, that.userFIO) && Objects.equals(userDateOfBirth, that.userDateOfBirth) && Objects.equals(userTelephoneNumber, that.userTelephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFIO, userDateOfBirth, userTelephoneNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserProfile.class.getSimpleName() + "[", "]")
                .add("userFIO = '" + userFIO + "'")
                .add("userDateOfBirth = '" + userDateOfBirth + "'")
                .add("userTelephoneNumber = '" + userTelephoneNumber + "'")
                .toString();
    }
}
