package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_PrimeNumberWithConcurrencyThreadState {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

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
            threads.add(thread);
            thread.start();

            Runnable statusReporter = () -> {
                while (true) {
                    printThreads(threads);
                }
            };
            Thread reporterThread = new Thread(statusReporter);
            reporterThread.start();
        }
    }
    private static void printThreads(List<Thread> threads) {
        System.out.println("\n Threads status: ");
        threads.forEach(thread -> System.out.println(thread.getState() + " "));
    }
}
