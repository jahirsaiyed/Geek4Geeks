package com.geek4geeks.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayManipulation {

//    https://www.hackerrank.com/challenges/crush/problem

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long max = Long.MIN_VALUE;
        // Write your code here
        long[] result = new long[n+1];
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            result[a-1] += k;
            result[b] -= k;
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i-1];
            if(result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }

    @Test
    public void test() {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1, 5, 3));
        numbers.add(Arrays.asList(4, 8, 7));
        numbers.add(Arrays.asList(6, 9, 1));
        Assertions.assertEquals(10, arrayManipulation(10, numbers));

        numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1, 2, 100));
        numbers.add(Arrays.asList(2, 5, 100));
        numbers.add(Arrays.asList(3, 4, 100));
        Assertions.assertEquals(200, arrayManipulation(5, numbers));
    }

}
