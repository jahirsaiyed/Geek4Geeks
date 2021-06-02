package com.geek4geeks.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RotateLeft {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        for (int i = 0; i < d; i++) {
            a = rotLeft(a);
        }
        return a;
    }

    private static List<Integer> rotLeft(List<Integer> a) {
        int last;
        if (a.size() > 0) last = a.get(0);
        else return a;
        for (int i = 0; i < a.size() - 1; i++) {
            a.set(i, a.get(i + 1));
        }
        a.set(a.size() - 1, last);
        return a;
    }

    @Test
    public void test() {
        System.out.println(rotLeft(Arrays.asList(1, 2, 3, 4, 5), 4));
    }

}
