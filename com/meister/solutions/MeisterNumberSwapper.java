package com.meister.solutions;

public class MeisterNumberSwapper {
    public static void Swap(int a, int b) {

        System.out.println("Before swapping:");
        System.out.println("A: " + a);
        System.out.println("B: " + b);

        System.out.println();

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping:");
        System.out.println("A: " + a);
        System.out.println("B: " + b);
    }
}
