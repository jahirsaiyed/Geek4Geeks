package com.geek4geeks.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Staircase {

//    https://www.hackerrank.com/challenges/ctci-recursive-staircase
    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int stepPerms(int n) {
        // Write your code here
//        return stepsPermsM(n, n <3 ? new int[3] : new int[n+1]);
        return stepPermsDP(n);
    }

    private static int stepsPermsM(int n, int[] memo) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] == 0) {
            memo[n] = stepsPermsM(n - 1, memo) + stepsPermsM(n - 2, memo) + stepsPermsM(n - 3, memo);
        }
        return memo[n];
    }

    public static int stepPermsGeneric(int n, int[] possible) {
        // Write your code here
        return stepsPermsMGeneric(n, new int[n + 1], possible);
    }

    private static int stepsPermsMGeneric(int n, int[] memo, int[] possible) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] == 0) {
            for (int i : possible) memo[n] += stepsPermsM(n - i , memo);
        }
        return memo[n];
    }

    public static int stepPermsDP(int n) {
        // Write your code here
        int[] steps = n <3 ? new int[3] : new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2] + steps[i-3];
        }
        return steps[n];
    }

    public static int stepPermsDPGeneric(int n, int[] possible) {
        // Write your code here
        int[] steps = n <3 ? new int[3] : new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j : possible) steps[i] += steps[i - j];
        }
        return steps[n];
    }

    @Test
    public void test() {
        Assertions.assertEquals(13, stepPerms(5));
        Assertions.assertEquals(13, stepPermsGeneric(5, new int[]{1, 2, 3}));
        Assertions.assertEquals(13, stepPermsDP(5));
        Assertions.assertEquals(13, stepPermsDPGeneric(5, new int[] {1, 2, 3}));
    }

}

