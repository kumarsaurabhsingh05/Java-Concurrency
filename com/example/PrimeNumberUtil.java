package com.example;

public class PrimeNumberUtil {
    public static int calculatePrime(int n) {
        int number;
        int numberOfPrimeFound;
        int i;
        number = 1;
        numberOfPrimeFound = 0;

        while (numberOfPrimeFound < n) {
            number++;
            for (i = 2; i <= number && number % i != 0; i++) {

            }
            if (i == number) {
                numberOfPrimeFound++;
            }
        }
        return number;
    }
}
