package com.problems;

import roughwork.PrimeNumberClass;

import java.util.Scanner;

/**
 * Created by kushagrathapar on 2/6/16.
 */
public class Problem7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int position;
        for(int i = 0; i < testCases; i++) {
            position = sc.nextInt();
            long startTime = System.nanoTime();
            System.out.println(generatePrimeNumber(position));
            System.out.println("Time taken in nano seconds [" + (System.nanoTime() - startTime) + "]");
        }
    }

    public static long generatePrimeNumber(int position) {
        return PrimeNumberClass.findPrimeAtPosition(position);
    }

}
