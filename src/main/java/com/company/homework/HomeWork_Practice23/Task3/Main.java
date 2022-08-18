package com.company.homework.HomeWork_Practice23.Task3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        PriorityQueue<Request> queue = new PriorityQueue<>();

        Client client1 = new Client(1);
        queue.offer(new Request(client1, LocalDateTime.now()));
        Client client2 = new Client(2);
        queue.offer(new Request(client2, LocalDateTime.now()));
        Client client30 = new Client(30);
        queue.offer(new Request(null, LocalDateTime.now()));
        Client client24 = new Client(24);
        queue.offer(new Request(client24, LocalDateTime.now()));
        Client client3 = new Client(3);
        queue.offer(new Request(client3, LocalDateTime.now()));

        while (queue.size() > 0 ) {
            System.out.println(queue.poll());
        }
    }
}
