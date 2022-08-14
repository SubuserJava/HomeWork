package com.company.homework.HomeWork_Practice24.Task2;

import java.util.Objects;
import java.util.TreeSet;

public class TranslateContainer {

    private TreeSet<String> translate;
    private int hitCounter;

    public TranslateContainer(TreeSet<String> translate) {
        this.translate = translate;
    }

    public TreeSet<String> getTranslate() {
        return translate;
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslateContainer that = (TranslateContainer) o;
        return Objects.equals(translate, that.translate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(translate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(translate);
        sb.append(", counter of rating = ").append(hitCounter);
        return sb.toString();
    }
}
