import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(fibo(n));
    }

    public static long fibo(int n) {
        if(dp[n] != 0) return dp[n];

        dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }
}
