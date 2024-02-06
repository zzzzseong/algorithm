import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final static int[][] dp = new int[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    public static int comb(int n, int r) {
        if(dp[n][r] != 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            dp[n][r] = 1;
            return dp[n][r];
        }

        dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
        return dp[n][r];
    }
}