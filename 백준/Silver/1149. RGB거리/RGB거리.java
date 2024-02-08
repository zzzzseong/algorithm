import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t =Integer.parseInt(br.readLine());

        int[][] house = new int[t][3];
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            house[i][0] = Integer.parseInt(line[0]);
            house[i][1] = Integer.parseInt(line[1]);
            house[i][2] = Integer.parseInt(line[2]);
        }

        int[][] dp = new int[t][3];
        dp[0] = house[0];

        for (int i = 1; i < house.length; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[t-1].length; i++) {
            min = Math.min(min, dp[t-1][i]);
        }

        System.out.println(min);
    }
}