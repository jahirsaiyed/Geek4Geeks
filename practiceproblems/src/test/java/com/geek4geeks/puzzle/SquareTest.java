package com.geek4geeks.puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SquareTest {

    public static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // code here
        int d1 = distance(x1, y1, x2, y2),
                d2 = distance(x2, y2, x3, y3),
                d3 = distance(x3, y3, x4, y4),
                d4 = distance(x4, y4, x1, y1);
        System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
        if(x1 == x2 & y1 == y2 && x3 == y3 && x4 == y4) {
            return "No";
        }
        if (d1 == d2 && d3 == d4 && d2 == d3) {
            return "YES";
        }
        return "No";
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return (int) java.lang.Math.pow(java.lang.Math.pow(x2 - x1, 2) + java.lang.Math.pow(y2 - y1, 2), 1 / 2);
    }

    @Test
    public void testSquare() {
        Assertions.assertEquals("YES", isSquare(20, 10, 10, 20, 20, 20, 10, 10));
        Assertions.assertEquals("No", isSquare(1, 1, 1, 1, 1, 1, 1, 1));
    }
}
