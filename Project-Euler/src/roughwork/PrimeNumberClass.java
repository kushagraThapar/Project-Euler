package roughwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kushagra.Thapar
 * Date: 8/30/13
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeNumberClass {

    public static final List<Long> primeNumbers = new ArrayList<>(10000);
    public static int lastIndex = 7;

    static {
        primeNumbers.add(0, 2L);
        primeNumbers.add(1, 3L);
        primeNumbers.add(2, 5L);
        primeNumbers.add(3, 7L);
        primeNumbers.add(4, 11L);
        primeNumbers.add(5, 13L);
        primeNumbers.add(6, 17L);
        primeNumbers.add(7, 19L);
        primeNumbers.add(8, 23L);
        primeNumbers.add(9, 29L);
        primeNumbers.add(10, 31L);
        primeNumbers.add(11, 37L);
    }

    public static boolean isPrime(long num) {
        if (num <= 1)
            return false;

        if (num < 4)
            return true;

        if (num % 2 == 0)
            return false;

        if (num < 9)
            return true;

        if (sumOfDigits(num) % 3 == 0)
            return false;

        if (num % 10 == 5)
            return false;

        double sqrt = Math.sqrt(num);
        long check = 6;
        for (long i = 1; check < sqrt; i++) {
            check = (i * 6) + 1;
            if (num % check == 0) {
                return false;
            }
            check = (i * 6) - 1;
            if (num % check == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfDigits(long num) {
        long digit;
        int sumOfDigits = 0;
        while (num > 0) {
            digit = num % 10;
            sumOfDigits += digit;
            num = num / 10;
        }
        return sumOfDigits;
    }

    public static long findPrimeAtPosition(int position) {
        System.out.println("Position [" + position + "], Size [" + primeNumbers.size() + "]");
        if (position <= primeNumbers.size()) {
            System.out.println("In If loop");
            return primeNumbers.get(position - 1);
        }
        int currentPosition = primeNumbers.size();
        long nextNum;
        for (int i = lastIndex; ; i++) {

            nextNum = (i * 6) - 1;
            if (isPrime(nextNum)) {
                if (!primeNumbers.contains(nextNum)) {
                    primeNumbers.add(currentPosition, nextNum);
                    currentPosition++;
                }
                //System.out.println("Current Position [" + currentPosition + "]");
                if (currentPosition == position) {
                    lastIndex = i;
                    return nextNum;
                }
            }

            nextNum = (i * 6) + 1;
            if (isPrime(nextNum)) {
                if (!primeNumbers.contains(nextNum)) {
                    primeNumbers.add(currentPosition, nextNum);
                    currentPosition++;
                }
                //System.out.println("Current Position [" + currentPosition + "]");
                if (currentPosition == position) {
                    lastIndex = i;
                    return nextNum;
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(findPrimeAtPosition(800000));
        long endTime = System.nanoTime();
        System.out.println("Time Taken in seconds is [" + (endTime - startTime) / 1000000000.0 + "]");

        /*long num = 29996224275833L;
        startTime = System.nanoTime();
        System.out.println(isPrime(num));
        endTime = System.nanoTime();
        System.out.println("Time Taken in milli seconds is [" + (endTime - startTime) / 1000000.0 + "]");*/

        /*starTime = System.nanoTime();
        if (num % 10 == 5) {
            System.out.println("Divisible");
        } else {
            System.out.println("Not Divisible");
        }
        System.out.println((System.nanoTime() - starTime));*/
    }
}
