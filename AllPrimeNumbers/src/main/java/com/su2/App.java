package com.su2;

/**
 * Hello world!
 *
 */
import java.util.*;
public class App {
    public static void sieveOfEratosthenes(int start, int end) {
        boolean[] prime = new boolean[end + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= end; p++) {
            if (prime[p]) {
                for (int j = p * p; j <= end; j += p) {
                    prime[j] = false;
                }
            }
        }
        System.out.println("Prime numbers are:");
        for (int i = Math.max(start, 2); i <= end; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start number:");
        int start = sc.nextInt();
        System.out.println("Enter end number:");
        int end = sc.nextInt();
        sieveOfEratosthenes(start, end);
        sc.close();
    }
}