package dynamicprogramming;

public class DP2ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countPathsMemoization(new long[n+1], n));
        System.out.println(countPathsTabulation(n));
    }

    static long countPathsMemoization(long[] dp, int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (dp[n] != 0 ) return dp[n];
        long count = countPathsMemoization(dp, n-1) + countPathsMemoization(dp, n-2) + countPathsMemoization(dp, n-3);
        dp[n] = count;
        return count;
    }

    static long countPathsTabulation(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >=0 ) dp[i] += dp[i-1];
            if (i - 2 >=0 ) dp[i] += dp[i-2];
            if (i - 3 >=0 ) dp[i] += dp[i-3];
        }
        return dp[n];
    }
}
