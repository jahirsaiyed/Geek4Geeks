package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrimeNumberTest {

    public static boolean isPrime(long number) {
        for (int i=2; i<=number/2; i++) {
            if (number %i ==0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void checkPrime() {
        Assertions.assertTrue(isPrime(5));
        Assertions.assertFalse(isPrime(4));
    }

    @Test
    public void printPrimeNumbersLess100() {
        for (int i=2; i<100; i++) {
            if (isPrime(i))
            System.out.print(i+" ");
        }
    }
}
