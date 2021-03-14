package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReverseDigitTest {

    public long reverse_digit(long n) {
        // Code here
        long number = 0;
        while (n > 0) {
            number = number * 10 + n % 10;
            n /= 10;
        }
        return number;
    }

    @Test
    public void testReverseDigit() {
        Assertions.assertEquals(51, reverse_digit(15));
        Assertions.assertEquals(51, reverse_digit(1500));
        Assertions.assertEquals(501, reverse_digit(105));
    }

}
