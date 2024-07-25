import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n+1];
        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];

        dp[1] = seq[1];

        if(n > 1) dp[2] = seq[2] + seq[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(seq[i]+seq[i-1]+dp[i-3], seq[i]+dp[i-2]));
        }

        System.out.println(dp[n]);
    }
}