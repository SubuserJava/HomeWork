package com.company.homework.HomeWork_Practice23.Task3;

public class Client {

    private Integer priority;

    public Client(int priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }
}
