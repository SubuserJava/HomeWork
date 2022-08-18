package com.company.homework.homework2;

public class Task08 {

    static final byte TIME_SEC = 5;
    static final short SOUND_SPEED_AIR = 343;

    public static void main(String[] args) {

        int lightningFlushDistance = TIME_SEC * SOUND_SPEED_AIR;
        System.out.println("lightning flash distance is " + lightningFlushDistance);

    }
}
