import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int round = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            sb.append("Problem ").append(round++).append(": ").append(bfs(n, cave)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int n, int[][] cave) {
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);

        dp[0][0] = cave[0][0];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});

        while(!dq.isEmpty()) {
            int[] pos = dq.poll();
            int x = pos[0];
            int y = pos[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= n || nx < 0 || ny >= n || ny < 0) continue;

                if(dp[x][y] + cave[nx][ny] < dp[nx][ny]) {
                    dp[nx][ny] = dp[x][y] + cave[nx][ny];
                    dq.offer(new int[]{nx, ny});
                }
            }
        }

        return dp[n-1][n-1];
    }
}