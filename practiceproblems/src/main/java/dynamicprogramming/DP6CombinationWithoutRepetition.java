package dynamicprogramming;

public class DP6CombinationWithoutRepetition {
    public static void main(String[] args) {
        System.out.println(present(new int[]{4,2,7,1,3}, 10));
    }

    // This is a problem of mathematical combinations to reach a sum with each sub element chosen only once.

    static boolean present(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j==0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j] || (j >= arr[i-1] && dp[i-1][j-arr[i-1]])) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[n][sum];
    }
}
