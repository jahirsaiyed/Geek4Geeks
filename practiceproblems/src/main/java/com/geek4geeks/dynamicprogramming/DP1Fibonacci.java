package dynamicprogramming;

public class DP1Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(new int[n+1], n)); // Recursion

    }

    static int fibonacci(int[] dp, int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 0 || n ==1) return n;
        System.out.println("Hello "+n);
        int fib = fibonacci(dp, n - 1) + fibonacci(dp,n - 2);
        dp[n] = fib;
        return fib;
    }
}
