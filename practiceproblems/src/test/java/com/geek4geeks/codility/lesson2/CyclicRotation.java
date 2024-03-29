package com.geek4geeks.codility.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if(A.length==0) return A;
        for (int i = 0; i < K; i++) {
            rotateRight(A);
        }
        return A;
    }

    private void rotateRight(int[] A) {
        int temp = A[A.length - 1];
        for (int i = A.length - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = temp;
    }

    @Test
    public void testBinaryGap() {

        TestCase[] testcases = new TestCase[]{
                new TestCase(new int[]{9, 7, 6, 3, 8}, new int[]{3, 8, 9, 7, 6}, 3),
                new TestCase(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 4),
                new TestCase(new int[]{}, new int[]{}, 1),
        };

        for (TestCase testcase : testcases) {
            int[] actual = solution(testcase.getInput(), testcase.getRotations());
            for (int i = 0; i < testcase.getExpected().length; i++) {
                Assertions.assertEquals(testcase.getExpected()[i], actual[i]);
            }
        }
    }

    class TestCase {
        int[] expected;
        int[] input;
        int rotations;

        public TestCase(int[] expected, int[] input, int rotations) {
            this.expected = expected;
            this.input = input;
            this.rotations = rotations;
        }

        public int[] getExpected() {
            return expected;
        }

        public int[] getInput() {
            return input;
        }

        public int getRotations() {
            return rotations;
        }
    }

//    An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//
//    The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//
//    Write a function:
//
//    class Solution { public int[] solution(int[] A, int K); }
//
//    that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
//
//    For example, given
//
//    A = [3, 8, 9, 7, 6]
//    K = 3
//    the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//
//            [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//            [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//            [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//    For another example, given
//
//    A = [0, 0, 0]
//    K = 1
//    the function should return [0, 0, 0]
//
//    Given
//
//    A = [1, 2, 3, 4]
//    K = 4
//    the function should return [1, 2, 3, 4]
//
//    Assume that:
//
//    N and K are integers within the range [0..100];
//    each element of array A is an integer within the range [−1,000..1,000].
//    In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
}
