package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BinaryToDecimal {

    public int binary_to_decimal(String str) {
        // Code here
        char[] chars = str.toCharArray();
        double decimal = 0;
        int length = chars.length;
        for (int i=length-1; i>=0; i--) {
            if(chars[i] == '1') {
                decimal = decimal + java.lang.Math.pow(2, length - i - 1);
            }
        }
        return (int) decimal;
    }

    @Test
    public void testBinaryToDecimal() {
        Assertions.assertEquals(20, binary_to_decimal("10100"));
        Assertions.assertEquals(20, binary_to_decimal("10100"));
    }


//    Given a Binary Number B, find its decimal equivalent.
//
//
//    Example 1:
//
//    Input: B = 10001000
//    Output: 136
//    Example 2:
//
//    Input: B = 101100
//    Output: 44
//
//
//    Your Task:
//    You don't need to read or print anything. Your task is to complete the function binary_to_decimal() which takes the binary number as string input parameter and returns its decimal equivalent.

}
