package com.geek4geeks.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NthRoot {

    public int NthRoot(int n, int m) {
        double root = java.lang.Math.pow(m, 1.0 / n);
        int roundedRoot = (int) java.lang.Math.round(root);
        if (roundedRoot - root > 0.00001) {
            return -1;
        }
        return roundedRoot;
    }

    @Test
    public void testNthRoot() {
        Assertions.assertEquals(3, NthRoot(2, 9));
        Assertions.assertEquals(5, NthRoot(3, 125));
        Assertions.assertNotEquals(5, NthRoot(4, 125));
        Assertions.assertNotEquals(5, NthRoot(3, 126));//TODO: Needs to be fixed.
    }

}
