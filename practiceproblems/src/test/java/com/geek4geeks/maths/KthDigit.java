package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KthDigit {

    static long kthDigit(int A,int B,int K){
        // code here
        long power = (long) Math.pow(A, B);
        for (int i=1; i<K; i++) {
            power /= 10;
        }
        return power % 10;
    }

    @Test
    public void testKthDigit() {
        Assertions.assertEquals(7, kthDigit(3,3, 1));
        Assertions.assertEquals(6, kthDigit(4,4, 1));
    }

//    Given two numbers A and B, find Kth digit from right of AB.
//
//
//    Example 1:
//
//    Input:
//    A = 3
//    B = 3
//    K = 1
//    Output:
//            7
//    Explanation:
//            33 = 27 and 1st
//    digit from right is
//7
//    Example 2:
//
//    Input:
//    A = 5
//    B = 2
//    K = 2
//    Output:
//            2
//    Explanation:
//            52 = 25 and second
//    digit from right is
//2.
//
//    Your Task:
//    You don't need to read input or print anything. Your task is to complete the function kthDigit() which takes integers A, B, K as input parameters and returns Kth Digit of AB from right side.
//
}
