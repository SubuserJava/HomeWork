package com.company.homework.HomeWork_Practice23.Task3;

import java.time.LocalDateTime;
import java.util.Objects;

public class Request implements Comparable<Request> {

    private final Client client;
    private final LocalDateTime dateTime;

    public Request(Client client, LocalDateTime dateTime) {
        this.client = client;
        this.dateTime = dateTime;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public int compareTo(Request o) {
        if (o.client == null) {
            return -1;
        } else if (this.client == null) {
            return o.client.getPriority();
        }
        return Integer.compare(o.client.getPriority(), this.client.getPriority());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Request{");
        sb.append("client=").append(client);
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(client, request.client) && Objects.equals(dateTime, request.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, dateTime);
    }
}
