package com.problems;

import java.util.Scanner;

/**
 * Created by kushagrathapar on 2/10/16.
 */
public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int numOfDigits;
        int digits;
        long num;
        for (int i = 0; i < testCases; i++) {
            numOfDigits = sc.nextInt();
            digits = sc.nextInt();
            num = sc.nextLong();
            System.out.println(longestSubSequenceProductBruteForce(numOfDigits, digits, num));
        }
        String s = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";

        System.out.println(longestSubSequenceProjectEuler(13, s));

    }

    public static int longestSubSequenceProduct(int numOfDigits, int digits, long num) {
        int product = 1;
        int count = 0;
        long singleDigit;
        int maxProduct = 0;
        long digitsArray[] = new long[numOfDigits];
        int firstDigit = 0;
        for (int i = 0; i < numOfDigits; i++) {
            count++;
            singleDigit = num % 10;
            digitsArray[i] = singleDigit;
            num = num / 10;
            product *= singleDigit;
            if (count == digits) {
                maxProduct = product > maxProduct ? product : maxProduct;
                count--;
                product /= (digitsArray[firstDigit] != 0 ? digitsArray[firstDigit] : 1);
                firstDigit++;
            }
        }
        return maxProduct;
    }

    public static long longestSubSequenceProductBruteForce(int numOfDigits, int digits, long num) {
        long singleDigit;
        long digitsArray[] = new long[numOfDigits];
        for (int i = 0; i < numOfDigits; i++) {
            singleDigit = num % 10;
            digitsArray[i] = singleDigit;
            num = num / 10;
        }
        return longestSubSequence(digits, digitsArray);
    }

    public static long longestSubSequence(int digits, long digitsArray[]) {
        long product;
        long maxProduct = 0;
        for (int startPos = 0, endPos = digits; endPos <= digitsArray.length; startPos++, endPos++) {
            product = findProduct(startPos, endPos, digitsArray);
            maxProduct = (product > maxProduct) ? product : maxProduct;
        }
        return maxProduct;
    }

    public static long findProduct(int startPos, int endPos, long[] digitsArray) {
        long product = 1;
        for (int i = startPos; i < endPos; i++) {
            product *= digitsArray[i];
        }
        return product;
    }

    public static long longestSubSequenceProjectEuler(int digits, String s) {
        long digitsArray[] = new long[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digitsArray[i] = Long.parseLong(s.substring(i, i + 1));
        }
        return longestSubSequence(digits, digitsArray);
    }
}
