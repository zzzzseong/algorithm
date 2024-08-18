import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] coins, dp;
    private static int n, k;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);

        dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    public static void main(String[] args) throws IOException {
        init();

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            if(coin > k) break;

            dp[coin] = 1;
            for (int j = coin+1; j <= k; j++) {
                if(dp[j-coin] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[coin]+dp[j-coin]);
            }
        }

        System.out.println(dp[k] != Integer.MAX_VALUE ? dp[k] : -1);
    }
}