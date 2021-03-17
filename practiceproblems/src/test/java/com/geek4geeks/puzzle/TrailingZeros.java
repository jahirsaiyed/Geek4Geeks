package com.geek4geeks.puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrailingZeros {

    static int trailingZeroes(int N) {
        // Write your code here
        int trailingZeros = 0;
        while(N / 5 > 0) {
            N /= 5;
            trailingZeros+=N;
        }
        return trailingZeros;
    }

    @Test
    public void testTrailingZeros() {
        Assertions.assertEquals(1, trailingZeroes(5));
        Assertions.assertEquals(94, trailingZeroes(384));
    }

    //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32  33 34 35 36 37 38 39 40
//    For an integer N find the number of trailing zeroes in N!.
//
//    Example 1:
//
//    Input:
//    N = 5
//    Output:
//            1
//    Explanation:
//            5! = 120 so the number of trailing zero is 1.
//    Example 2:
//
//    Input:
//    N = 4
//    Output:
//            0
//    Explanation:
//            4! = 24 so the number of trailing zero is 0.
//    Your Task:
//    You don't need to read input or print anything. Your task is to complete the function trailingZeroes() which take an integer N as an input parameter and returns the count of trailing zeroes in the N!.
//Expected Time Complexity: O(logN)

}
