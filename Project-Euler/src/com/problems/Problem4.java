package com.problems;

/**
 * Created by kushagrathapar on 2/5/16.
 */

import java.util.Scanner;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        long num;
        long startTime, endTime;
        for (int i = 0; i < testCases; i++) {
            num = sc.nextLong();
            startTime = System.nanoTime();
            //System.out.println("Palindrome is [" + getPalindromeWithinDescending(num) + "]");
            System.out.println("Palindrome is [" + getPalindromeWithinAscending(num) + "]");
            endTime = System.nanoTime();
            System.out.println("Time Taken in nano seconds [" + (endTime - startTime) + "]");
        }
    }

    public static long getPalindromeWithinDescending(long num) {
        long product;
        for (long i = 999; i > 99; i--) {
            for (long j = 999; j > 99; j--) {
                product = i * j;
                if (product < num && isPalindrome(product)) {
                    return product;
                }
            }
        }
        return 101101L;
    }

    public static long getPalindromeWithinAscending(long num) {
        long product;
        long lastPalindrome = 101101L;
        for (long i = 101; i <= 999; i++) {
            for (long j = 101; j <= 999; j++) {
                product = i * j;
                if (product < num) {
                    if(isPalindrome(product)) {
                        //System.out.println("Last Palindrome [" + lastPalindrome + "]");
                        lastPalindrome = (lastPalindrome < product) ? product : lastPalindrome;
                    }
                }
            }
        }
        return lastPalindrome;
    }

    public static boolean isPalindrome(long num) {
        long reverseNum = 0;
        long original = num;
        while (num > 0) {
            reverseNum = reverseNum * 10 + (num % 10);
            num = num / 10;
        }
        return reverseNum == original;
    }
}
