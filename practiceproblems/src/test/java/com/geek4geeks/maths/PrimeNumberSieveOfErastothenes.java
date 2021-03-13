package com.geek4geeks.maths;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
public class PrimeNumberSieveOfErastothenes {
//    https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
//    A prime number is a natural number that has exactly two distinct natural number divisors: the number 1 and itself.
//
//    To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
//
//    Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
//    Initially, let p equal 2, the smallest prime number.
//    Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
//    Find the smallest number in the list greater than p that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
//    When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.

    public static ArrayList<Integer> sieveOfEratosthenes(int N) {
        // code here
        boolean primes[] = new boolean[N+1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }

        ArrayList<Integer> primeNos = new ArrayList<>();
        for (int i = 2; i <= N; i++) if (primes[i]) primeNos.add(i);
        return primeNos;
    }

    @Test
    public void testPrimeNos() {
        System.out.println(sieveOfEratosthenes(30));
        System.out.println(sieveOfEratosthenes(500));
        sieveOfEratosthenes(1000);
        sieveOfEratosthenes(50000000);
    }
}
