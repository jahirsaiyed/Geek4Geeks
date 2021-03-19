package com.geek4geeks.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayRowColumnSum {

    public String solution(int U, int L, int[] C) {
        int total = 0;
        for (int v : C) {
            total += v;
        }

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        int row1 = 0, row2 = 0;

        if (total != U + L) {
            return "IMPOSSIBLE";
        } else {
            for (int v : C) {
                if (v == 2) {
                    str1.append("1");
                    str2.append("1");
                } else if (v == 0) {
                    str1.append("0");
                    str2.append("0");
                } else if (v == 1) {
                    if (row1 < U) {
                        str1.append("1");
                        str2.append("0");
                        row1++;
                    } else if (row2 < L) {
                        str1.append("0");
                        str2.append("1");
                        row2++;
                    }
                }
            }
            return str1.append(',').append(str2).toString();
        }
    }

    @Test
    public void testArrayRowColumnSum() {
        //TODO: Dont have a way to assert correctness of the solution so just printing on console.
        System.out.println(solution(3, 2, new int[]{2, 1, 1, 0, 1}));
    }


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
