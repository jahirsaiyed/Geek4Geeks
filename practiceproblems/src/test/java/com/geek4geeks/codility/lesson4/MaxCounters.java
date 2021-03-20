package com.geek4geeks.codility.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] X = new int[N];
        int max = 0, lastMax = 0;
        for (int k = 0; k < A.length; k++) {
            if (A[k] != N + 1) {
                X[A[k] - 1] = Math.max(X[A[k] - 1], lastMax);
                X[A[k] - 1]++;
                max = Math.max(X[A[k] - 1], max);
            } else {
                lastMax = max;
            }
        }
        for (int i = 0; i < X.length; i++) {
            X[i] = Math.max(X[i], lastMax);
        }
        return X;
    }

    @Test
    public void testMaxCounters() {
        TestCase[] testcases = new TestCase[]{
                new TestCase(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2}),
                new TestCase(1, new int[]{1}, new int[]{1}),
        };

        for (TestCase testcase : testcases) {
            for (int i = 0; i < testcase.getExpected().length; i++) {
                int[] solution = solution(testcase.getN(), testcase.getA());
                Assertions.assertEquals(testcase.getExpected()[i], solution[i]);
            }
        }
    }

    class TestCase {
        int N;
        int[] A;
        int[] expected;

        public TestCase(int n, int[] a, int[] expected) {
            N = n;
            A = a;
            this.expected = expected;
        }

        public int getN() {
            return N;
        }

        public int[] getA() {
            return A;
        }

        public int[] getExpected() {
            return expected;
        }
    }

//    You are given N counters, initially set to 0, and you have two possible operations on them:
//
//    increase(X) − counter X is increased by 1,
//    max counter − all counters are set to the maximum value of any counter.
//    A non-empty array A of M integers is given. This array represents consecutive operations:
//
//            if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
//if A[K] = N + 1 then operation K is max counter.
//    For example, given integer N = 5 and array A such that:
//
//    A[0] = 3
//    A[1] = 4
//    A[2] = 4
//    A[3] = 6
//    A[4] = 1
//    A[5] = 4
//    A[6] = 4
//    the values of the counters after each consecutive operation will be:
//
//            (0, 0, 1, 0, 0)
//            (0, 0, 1, 1, 0)
//            (0, 0, 1, 2, 0)
//            (2, 2, 2, 2, 2)
//            (3, 2, 2, 2, 2)
//            (3, 2, 2, 3, 2)
//            (3, 2, 2, 4, 2)
//    The goal is to calculate the value of every counter after all operations.
//
//    Write a function:
//
//    class Solution { public int[] solution(int N, int[] A); }
//
//    that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
//
//    Result array should be returned as an array of integers.
//
//    For example, given:
//
//    A[0] = 3
//    A[1] = 4
//    A[2] = 4
//    A[3] = 6
//    A[4] = 1
//    A[5] = 4
//    A[6] = 4
//    the function should return [3, 2, 2, 4, 2], as explained above.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N and M are integers within the range [1..100,000];
//    each element of array A is an integer within the range [1..N + 1].

}
