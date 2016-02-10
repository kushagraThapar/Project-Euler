package com.problems;

import java.util.Scanner;

/**
 * Created by kushagrathapar on 2/6/16.
 */
public class Problem6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int num;
        for(int i = 0; i < testCases; i++) {
            num = sc.nextInt();
            System.out.println(difference(num));
        }
    }

    public static long difference(long num) {
        long sumOfSquares = (num) * (num + 1) * ((2 * num)+ 1) / 6;
        long squareOfSum = (long) Math.pow((num * (num + 1) / 2), 2);
        return squareOfSum - sumOfSquares;
    }
}
