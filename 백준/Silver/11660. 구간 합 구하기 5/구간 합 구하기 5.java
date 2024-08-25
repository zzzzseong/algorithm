import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] map = new int[N][N];
        int[][] dp = new int[N+1][N+1];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= 1; j--) {
                dp[i][j] =  map[i-1][j-1];
                if(j+1 <= N) dp[i][j] += dp[i][j+1];
                if(i+1 <= N) dp[i][j] += dp[i+1][j];
                if(j+1 <= N && i+1 <= N) dp[i][j] -= dp[i+1][j+1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] xy = br.readLine().split(" ");

            int x1 = Integer.parseInt(xy[0]);
            int y1 = Integer.parseInt(xy[1]);
            int x2 = Integer.parseInt(xy[2]);
            int y2 = Integer.parseInt(xy[3]);

            int sum = dp[x1][y1];
            if(y2+1 <= N) sum -= dp[x1][y2+1];
            if(x2+1 <= N) sum -= dp[x2+1][y1];
            if(x2+1 <= N && y2+1 <= N) sum += dp[x2+1][y2+1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}