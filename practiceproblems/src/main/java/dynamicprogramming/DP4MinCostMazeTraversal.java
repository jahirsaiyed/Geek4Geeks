package dynamicprogramming;

public class DP4MinCostMazeTraversal {
    public static void main(String[] args) {
        System.out.println(countMin(new int[][]{
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        }));
    }

    static int countMin(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] dp = new int[n][m];

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i == n-1 && j == m-1) {
                    dp[n-1][m-1] = arr[n-1][m-1];
                } else if(j == m-1) {
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                } else if(i == n-1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
