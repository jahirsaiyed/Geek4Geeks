package dynamicprogramming;

public class DP2ClimbingStairsVariableJumps {
    public static void main(String[] args) {
        int[] jumps = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(countMinJumps(jumps));
    }

    static long countMinJumps(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n+1];
        dp[n] = 1;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length ; j++) {
                dp[i] += dp[i+j];
            }
            System.out.print(dp[i] + " ");
        }
        return dp[0];
    }
}
