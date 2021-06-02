package com.geek4geeks.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MinimumBribes {

//    https://www.hackerrank.com/challenges/new-year-chaos/problem
    public static int minimumBribes(List<Integer> q) {
        int totalBribes = 0;
        // Write your code here
        for (int i = 0; i < q.size(); i++) {
             int bribe = q.get(i) - i - 1;
             if (bribe > 2) {
                 System.out.println("Too chaotic");
                 return -1;
             } else if(bribe < 0) {
                 totalBribes += (-1*bribe);
             }
        }
        return totalBribes;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, minimumBribes(Arrays.asList(2, 1, 5, 3, 4)));
        Assertions.assertEquals(7, minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4)));
    }
}
