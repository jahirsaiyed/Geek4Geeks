package com.geek4geeks.hackerrank;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Logger
public class HourglassSum {
    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        List<List<Integer>> hourGlasses = new ArrayList<>();
        // Write your code here
        for (int i = 1; i < arr.size() - 1; i++) {
            List<Integer> hourGlass = new ArrayList<>();
            for (int j = 1; j < arr.get(i).size() - 1; j++) {
                int sum = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1)
                        + arr.get(i).get(j)
                        + arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1);
                hourGlass.add(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
            hourGlasses.add(hourGlass);
        }
        System.out.println(hourGlasses);
        return maxSum;
    }

    @Test
    public void test() {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        numbers.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        numbers.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        numbers.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        numbers.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        numbers.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        Assertions.assertEquals(19, hourglassSum(numbers));
        numbers = new ArrayList<>();
        numbers.add(Arrays.asList(-9, -9, -9, 1, 1, 1));
        numbers.add(Arrays.asList(0, -9, 0, 4, 3, 2));
        numbers.add(Arrays.asList(-9, -9, -9, 1, 2, 3));
        numbers.add(Arrays.asList(0, 0, 8, 6, 6, 0));
        numbers.add(Arrays.asList(0, 0, 0, -2, 0, 0));
        numbers.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        Assertions.assertEquals(28, hourglassSum(numbers));

        numbers = new ArrayList<>();
        numbers.add(Arrays.asList(-1, -1, 0, -9, -2, -2));
        numbers.add(Arrays.asList(-2, -1, -6, -8, -2, -5));
        numbers.add(Arrays.asList(-1, -1, -1, -2, -3, -4));
        numbers.add(Arrays.asList(-1, -9, -2, -4, -4, -5));
        numbers.add(Arrays.asList(-7, -3, -3, -2, -9, -9));
        numbers.add(Arrays.asList(-1, -3, -1, -2, -4, -5));
        Assertions.assertEquals(-6, hourglassSum(numbers));
    }
}
