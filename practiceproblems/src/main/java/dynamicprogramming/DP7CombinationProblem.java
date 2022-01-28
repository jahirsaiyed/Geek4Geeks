package dynamicprogramming;

import java.util.Arrays;

class DP7CombinationProblem {

    public static void main(String[] args) {
        System.out.println(count(20));
    }

    // This is a problem of mathematical combinations to reach a sum where each element can be chosen multiple times.
    // Order does not matter

    public static long count(int n) {
        long[] dp = new long[n +1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int[] coins = new int[] {3,5,10};

        for (int coin : coins) {
            for(int i=1; i<=n; i++) {
                if(i-coin >= 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[n];
    }
}