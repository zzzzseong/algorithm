import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    private static int n, m;
    private static int sx, sy;

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] matrix;
    private static int[][] dp;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            String[] row = br.readLine().split(" ");

            for(int j=0; j<m; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                if(matrix[i][j] == 0) dp[i][j] = 0;
                if(matrix[i][j] == 2) {
                    sx = i; sy = j;
                }
            }
        }

        dp[sx][sy] = 0;
    }

    public static void main(String[] args) throws IOException {
        init();

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{sx, sy});

        while(!dq.isEmpty()) {
            int[] pos = dq.poll();

            for (int[] d : dir) {
                int nx = pos[0] + d[0];
                int ny = pos[1] + d[1];

                if(nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if(matrix[nx][ny] != 1 || dp[nx][ny] != -1) continue;

                dp[nx][ny] = dp[pos[0]][pos[1]]+1;
                dq.offer(new int[]{nx, ny});
            }
        }

        // print answer
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) answer.append(dp[i][j]).append(" ");
            answer.append("\n");
        }

        System.out.println(answer);
    }
}