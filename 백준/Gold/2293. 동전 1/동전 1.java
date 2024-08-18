import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int n, k;

    private static int[] coins;
    private static int[] dp;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        coins = new int[n];
        dp = new int[k+1];

        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);
    }

    public static void main(String[] args) throws IOException {
        init();

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) dp[j] += dp[j - coins[i]];
        }

        System.out.println(dp[k]);
    }
}