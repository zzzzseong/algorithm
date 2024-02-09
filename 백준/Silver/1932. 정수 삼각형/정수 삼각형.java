import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * */

public class Main {
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        // 배열 세팅
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], Integer.MIN_VALUE);
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        // map 세팅
        for (int i = 0; i < map.length; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = map[0][0];
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == Integer.MIN_VALUE) break;

                if(j-1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + map[i][j]);
                }

                if(map[i][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + map[i][j]);
                }
            }
        }

        int max = dp[N-1][0];
        for (int i = 1; i < dp[N-1].length; i++) {
            max = Math.max(max, dp[N-1][i]);
        }

        System.out.println(max);
    }
}