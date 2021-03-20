package com.geek4geeks.codility.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class MissingInteger {

    public static int solution2(int[] A) {
        Set<Integer> elements = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                elements.add(A[i]);
            }
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!elements.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    //Solution 1 is wrong as assumption is A can have only positive numbers. But the problem has negative numbers as well.
    public static int solution1(int[] A) {

        int total = ((A.length) * (A.length + 1)) / 2;
        for (int i = 0; i < A.length; i++) {
            total -= A[i];
        }

        if(total > A.length) {
            return total - A.length;
        } else if (total == 0) {
            return A.length + 1;
        } else {
            return total + 1;
        }
    }

    @Test
    public void testMaxCounters() {
        TestCase[] testcases = new TestCase[]{
                new TestCase(new int[]{1, 3, 6, 4, 1, 2}, 5),
                new TestCase(new int[]{1, 2, 3}, 4),
                new TestCase(new int[]{-1, -3}, 1),
        };

        for (TestCase testcase : testcases) {
            Assertions.assertEquals(testcase.getExpected(), solution2(testcase.getA()));
        }
    }

    class TestCase {
        int[] A;
        int expected;

        public TestCase(int[] a, int expected) {
            A = a;
            this.expected = expected;
        }

        public int[] getA() {
            return A;
        }

        public int getExpected() {
            return expected;
        }
    }

//    This is a demo task.
//
//    Write a function:
//
//    class Solution { public int solution(int[] A); }
//
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//    Given A = [1, 2, 3], the function should return 4.
//
//    Given A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].
}
