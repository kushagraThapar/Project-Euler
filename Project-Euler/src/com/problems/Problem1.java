package com.problems;

/**
 * Created by kushagrathapar on 1/29/16.
 */

import java.util.Scanner;

/**
 * Problem - 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        int num;
        for(int i = 0; i < numOfTestCases; i++) {
            num = sc.nextInt();
            System.out.println("Sum is ["+ calculateSum(num) + "]");
        }
    }

    public static long calculateSum(int num){
        num = num - 1;
        long startTime = System.nanoTime();
        long numberOfTerms = num / 3;
        long sumOfThree =  numberOfTerms * (3 + (numberOfTerms * 3)) / 2;
        numberOfTerms = num / 5;
        long sumOfFive = numberOfTerms * (5 + (numberOfTerms * 5)) / 2;
        numberOfTerms = num / 15;
        long sumOfFifteen = numberOfTerms * (15 + (numberOfTerms * 15)) / 2;
        long sum = sumOfThree + sumOfFive - sumOfFifteen;
        System.out.println("Time taken in nano seconds is [" + (System.nanoTime() - startTime) + "]");
        return sum;
    }
}
