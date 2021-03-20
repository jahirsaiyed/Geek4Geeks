package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GCD {

    public int gcd(int A, int B) {
        //code here
        while (A != B) {
            if(A > B)
                A = A - B;
            else
                B = B - A;
        }
        return B;
    }

    @Test
    public void testGCD() {
        Assertions.assertEquals(3, gcd(3, 6));
        Assertions.assertEquals(1, gcd(1, 1));
        Assertions.assertEquals(1, gcd(1, 10));
        Assertions.assertEquals(2, gcd(12, 14));
    }

//    Given two positive integers A and B, find GCD of A and B.
//
//
//    Example 1:
//
//    Input: A = 3, B = 6
//    Output: 3
//    Explanation: GCD of 3 and 6 is 3
//
//    Example 2:
//
//    Input: A = 1, B = 1
//    Output: 1
//    Explanation: GCD of 1 and 1 is 1
//
//    Your Task:
//    You don't need to read input or print anything. Complete the function gcd() which takes two positive integers as input parameters and returns an integer.
}
