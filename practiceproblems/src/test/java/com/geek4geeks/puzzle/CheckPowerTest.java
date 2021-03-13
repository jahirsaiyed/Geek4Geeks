package com.geek4geeks.puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CheckPowerTest {

    static int isPowerOfAnother(Long X, Long Y) {
        // code here
        int power = 0;
        while (Y % X == 0 && X != 1 && X != 0) {
            power++;
            Y /= X;
        }
        return power;
    }

    @Test
    public void testPower() {
        Assertions.assertEquals(3, isPowerOfAnother(2l, 8l));
        Assertions.assertEquals(0, isPowerOfAnother(1l, 3l));
        Assertions.assertEquals(10, isPowerOfAnother(2l, 1024l));
    }


}

//    Given two positive numbers X and Y, check if Y is a power of X or not.
//
//
//
//        Example 1:
//
//        Input:
//        X = 2, Y = 8
//        Output:
//        1
//        Explanation:
//        23 is equal to 8.
//
//
//        Example 2:
//
//        Input:
//        X = 1, Y = 3
//        Output:
//        0
//        Explanation:
//        Any power of 1 is not
//        equal to 8.
//
//
//        Your Task:
//
//        You don't need to read input or print anything. Your task is to complete the function isPowerOfAnother() which takes an integer and returns 1 if y is the power of x, else return 0.
