package com.example;

import com.example.PrimeNumberUtil;

import java.util.Scanner;

public class C_PrimeNumberWithConcurrencyDaemon {
    public static void main(String[] args) {
        int number;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n I can tell you the nth prime number. Enter n: ");
            int n = sc.nextInt();
            if (n == 0) break;
            
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n Result: ");
                    System.out.println("\n Value of " + n + "th prime: " + number);
                }
            };
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
        }
    }
}
