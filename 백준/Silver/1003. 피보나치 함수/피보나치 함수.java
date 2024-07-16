import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] dp;
    private static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        vis = new boolean[41];
        vis[0] = true; vis[1] = true;

        int[] fibo = fibo(40);
        dp[40][0] = fibo[0];
        dp[40][1] = fibo[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] fibo(int n) {
        if(vis[n]) return dp[n];

        int[] fibo1 = fibo(n - 1);
        int[] fibo2 = fibo(n - 2);

        dp[n][0] = fibo1[0] + fibo2[0];
        dp[n][1] = fibo1[1] + fibo2[1];

        vis[n] = true;
        return dp[n];
    }
}