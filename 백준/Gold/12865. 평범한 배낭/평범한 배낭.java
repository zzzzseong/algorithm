import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BAEKJOON */
public class Main {
    private static int N, K;
    private static int[][] items;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(getAnswer());
    }

    public static int getAnswer() {
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int W = items[j][0];
                int V = items[j][1];

                if(W > i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], V + dp[i-W][j-1]);
                }
            }
        }

        return dp[K][N];
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        K = Integer.parseInt(firstLine[1]);

        items = new int[N+1][2]; //W, V
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(line[0]);
            items[i][1] = Integer.parseInt(line[1]);
        }

        dp = new int[K+1][N+1];
    }
}