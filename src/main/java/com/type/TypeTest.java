package com.type;

public class TypeTest {

    public static void main(String[] args) {
        System.out.println(Operation.MINUS);

        System.out.println(Operation.fromString("PLUS"));

        System.out.println(Operation.valueOf("PLUS"));

        int i = 0;
        System.out.println(i/i);

    }
}
