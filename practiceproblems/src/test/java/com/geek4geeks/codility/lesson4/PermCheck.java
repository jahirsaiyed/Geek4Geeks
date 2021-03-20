package com.geek4geeks.codility.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class PermCheck {

    public static int solution(int[] A) {
        Set<Integer> elements = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            elements.add(A[i]);
        }
        for (int i = 1; i <= A.length; i++) {
            if(!elements.contains(i)) return 0;
        }
        return 1;
    }


    @Test
    public void testMaxCounters() {
        TestCase[] testcases = new TestCase[]{
                new TestCase(new int[]{4,1,3,2}, 1),
                new TestCase(new int[]{4,1,3}, 0),
        };

        for (TestCase testcase : testcases) {
            Assertions.assertEquals(testcase.getExpected(), solution(testcase.getA()));
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

//    A non-empty array A consisting of N integers is given.
//
//    A permutation is a sequence containing each element from 1 to N once, and only once.
//
//    For example, array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//    is a permutation, but array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    is not a permutation, because value 2 is missing.
//
//    The goal is to check whether array A is a permutation.
//
//    Write a function:
//
//    class Solution { public int solution(int[] A); }
//
//    that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
//
//    For example, given array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//    the function should return 1.
//
//    Given array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    the function should return 0.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [1..1,000,000,000].
}
