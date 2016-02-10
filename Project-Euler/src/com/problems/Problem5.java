package com.problems;

import roughwork.PrimeNumberClass;

import java.util.Scanner;

/**
 * Created by kushagrathapar on 2/6/16.
 */
public class Problem5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int num;
        long startTime, endTime;
        for (int i = 0; i < testCases; i++) {
            num = sc.nextInt();
            startTime = System.nanoTime();
            System.out.println("Numbers is [" + findMinimumNumberDivisible(num) + "]");
            endTime = System.nanoTime();
            System.out.println("Time taken in nano seconds is [" + (endTime - startTime) + "]");
        }
    }

    public static long findMinimumNumberDivisible(int num) {
        if(num == 1) {
            return 1;
        }
        long twos = 1;
        long threes = 1;
        while((twos * 2) <= num) {
            twos *= 2;
        }
        while((threes * 3) <= num) {
            threes *= 3;
        }
        long result = twos * threes;
        for(long prime : PrimeNumberClass.primeNumbers) {
            if(prime > 3 && prime <= num) {
                result *= prime;
            }
        }
        return result;
    }
}
