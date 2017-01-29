package com.problems;

import java.util.Scanner;

/**
 * Created by kushagrathapar on 2/12/16.
 */
public class Problem9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int num;
        for (int i = 0; i < testCases; i++) {
            num = sc.nextInt();
            System.out.println(getPythagoreanTripletBruteForce(num));
        }
    }

    public static int getPythagoreanTripletProduct(int num) {
        int product = -1;
        int maxProduct = Integer.MIN_VALUE;
        int a, b, c;
        b = num / 3;
        a = b - 1;
        c = b + 1;
        while (getSquare(a) + getSquare(b) >= getSquare(c)) {
            if (isPythagoreanTriplet(a, b, c)) {
                product = a * b * c;
                maxProduct = product > maxProduct ? product : maxProduct;
            }
            a--;
            c++;
        }
        return product;
    }

    public static int getSquare(int a) {
        return (int) Math.pow(a, 2);
    }

    public static boolean isPythagoreanTriplet(int a, int b, int c) {
        return getSquare(a) + getSquare(b) == getSquare(c);
    }

    public static int getPythagoreanTripletBruteForce(int num) {
        int product = -1;
        int maxProduct = Integer.MIN_VALUE;
        if (num < 12) {
            return product;
        }
        int a, b, c;
        for (a = 3; a <= (num - 3) / 3; a++) {
            for (b = a + 1; b <= (num - 1 - a) / 2 ; b++) {
                c = num - (a + b);
                if(isPythagoreanTriplet(a, b, c)) {
                    product = a * b * c;
                    maxProduct = product > maxProduct ? product : maxProduct;
                    System.out.println(a + " " + b + " " + c);
                }
            }
        }
        return maxProduct;
    }

    public static int recursiveGCD(int a, int b) {
        if(b == 1) {
            return a;
        }
        return recursiveGCD(b, a % b);
    }

    public static int iterativeGCD(int a, int b) {
        int rem;
        int temp;
        if(a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while(a % b != 0) {
            rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}
