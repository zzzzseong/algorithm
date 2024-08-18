import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int n, k;
    private static int answer = 0;

    private static int[] coins;
    private static int[][] dp;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp = new int[k+1][n];
    }

    public static void main(String[] args) throws IOException {
        init();

        Arrays.fill(dp[0], 1);

        for (int i = 0; i < n; i++) {
            if(coins[i] <= k) dp[coins[i]][i] = 1;
        }

        for (int i = 1; i < k+1; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= j; l++) {
                    if(i + coins[j] <= k) dp[i+coins[j]][j] += dp[i][l];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer += dp[k][i];
        }

        System.out.println(answer);
    }
}