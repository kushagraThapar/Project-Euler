package com.problems;

/**
 * Created by kushagrathapar on 2/2/16.
 */

import roughwork.PrimeNumberClass;

import java.util.Scanner;

/**
 * Problem-3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */


public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        long num;
        for(int i = 0; i < testCases; i++) {
            num = sc.nextLong();
            //long startTime = System.nanoTime();
            System.out.println(largestPrimeFactor(num));
            //long endTime = System.nanoTime();
            //System.out.println("Time taken in nano seconds is [" + (endTime - startTime) + "]");
        }
    }


    public static long largestPrimeFactor(long num) {
        long newNum;
        long half = num / 2;
        for(long i = 2; i <= half; i++) {
            if(num % i == 0) {
                newNum = num / i;
                if (PrimeNumberClass.isPrime(newNum)) {
                    return newNum;
                }
            }
        }
        return 1;
    }
}
