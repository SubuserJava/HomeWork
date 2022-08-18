package com.company.homework.practice30.Task04;

import java.time.Year;
import java.util.Objects;

public class Television {

    private String modelName;
    private Year yearIssue;
    private Long price;
    private String screenDiagonal;
    private String manufacturer;

    public Television(String televisionModelName, Year yearIssue, Long priceTelevision, String diagonalTelevision, String manufacturerTelevision) {
        this.modelName = televisionModelName;
        this.yearIssue = yearIssue;
        this.price = priceTelevision;
        this.screenDiagonal = diagonalTelevision;
        this.manufacturer = manufacturerTelevision;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Year getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(Year yearIssue) {
        this.yearIssue = yearIssue;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setDiagonalTelevision(String diagonalTelevision) {
        this.screenDiagonal = diagonalTelevision;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return Objects.equals(modelName, that.modelName) && Objects.equals(yearIssue, that.yearIssue)
                && Objects.equals(price, that.price) && Objects.equals(screenDiagonal, that.screenDiagonal)
                && Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, yearIssue, price, screenDiagonal, manufacturer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Television{");
        sb.append("nameTelevision='").append(modelName).append('\'');
        sb.append(", yearIssue=").append(yearIssue);
        sb.append(", priceTelevision=").append(price);
        sb.append(", diagonalTelevision=").append(screenDiagonal);
        sb.append(", manufacturerTelevision='").append(manufacturer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
