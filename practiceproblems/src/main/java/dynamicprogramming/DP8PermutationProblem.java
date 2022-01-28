package dynamicprogramming;

public class DP8PermutationProblem {

    public static void main(String[] args) {
        System.out.println(count(new int[]{2,3,5,6}, 7));
    }

    static int count(int[] arr, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j]) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }

        return dp[sum];
    }

}
