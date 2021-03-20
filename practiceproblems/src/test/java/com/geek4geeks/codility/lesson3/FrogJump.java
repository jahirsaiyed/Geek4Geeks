package com.geek4geeks.codility.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FrogJump {

    public int solution(int X, int Y, int D) {

        int frogJump = (Y - X) / D;
        if ((Y - X) % D != 0) {
            frogJump++;
        }
        return frogJump;
    }

    @Test
    public void testLesson2OddOccurrencesInArray() {

        TestCase[] testcases = new TestCase[]{
                new TestCase(10, 85, 30, 3)
        };

        for (TestCase testcase : testcases) {
            Assertions.assertEquals(testcase.getExpected(), solution(testcase.getX(), testcase.getY(), testcase.getD()));
        }
    }

    class TestCase {
        int X;
        int Y;
        int D;
        int expected;

        public TestCase(int x, int y, int d, int expected) {
            X = x;
            Y = y;
            D = d;
            this.expected = expected;
        }

        public int getX() {
            return X;
        }

        public int getY() {
            return Y;
        }

        public int getD() {
            return D;
        }

        public int getExpected() {
            return expected;
        }
    }

//    A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
//
//    Count the minimal number of jumps that the small frog must perform to reach its target.
//
//    Write a function:
//
//    class Solution { public int solution(int X, int Y, int D); }
//
//    that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
//
//    For example, given:
//
//    X = 10
//    Y = 85
//    D = 30
//    the function should return 3, because the frog will be positioned as follows:
//
//    after the first jump, at position 10 + 30 = 40
//    after the second jump, at position 10 + 30 + 30 = 70
//    after the third jump, at position 10 + 30 + 30 + 30 = 100
//    Write an efficient algorithm for the following assumptions:
//
//    X, Y and D are integers within the range [1..1,000,000,000];
//    X ≤ Y.

}
