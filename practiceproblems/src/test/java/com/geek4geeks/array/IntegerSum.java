package com.geek4geeks.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class IntegerSum {

    public int solution1(int N) {
        int total = sumOfdigits(N);
        while (sumOfdigits(++N) != total) ;
        return N;
    }

    private int sumOfdigits(int N) {
        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }
        return sum;
    }

    //TODO: Complete solution 2
    public int solution2(int N) {
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = N;
        while (temp > 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
//        1990,  1234, 1233, 1243
        int digitAtIndex = digits.get(0);
        if(digitAtIndex != 0) {
            digits.set(0, digitAtIndex -1);
        }
        return N;
    }

    @Test
    public void testIntegerSum() {
        Assertions.assertEquals(37, solution1(28));
        Assertions.assertEquals(743, solution1(734));
        Assertions.assertEquals(2089, solution1(1990));
    }

//    @Test
//    public void testArrayRowColumnSum() {
//        Assertions.assertEquals(37, solution1(28));
//        Assertions.assertEquals(743, solution1(734));
//        Assertions.assertEquals(2089, solution1(1990));
//    }


//    I have a binary matrix with only 2 rows and N columns.
//
//    The sum of elements in first row is A and sum of elements in 2nd row is B.
//
//    The sum of columns is stored in an array C.
//
//    If A = 3, B = 2, C = [2,1,1,0,1] Then output is "11001,10100"
//
//    Explanation:
//            11001 = sum of 1st row is A = 3
//10100 = sum of 2nd row is B = 2
//
//21101 --> This is column sum which indicates Array C.
//    Another example:
//
//    If A = 2, B = 3, C = [0,0,1,1,2] Then output is "NO"

}
