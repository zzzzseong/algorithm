import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 각 자리에는 0-9까지의 정수가 위치할 수 있다. */
/* 1 <= N <= 1,000 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];
        for(int i=0; i<10; i++) dp[1][i] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                for(int k=j; k<10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10_007;
                }
            }
        }

        int answer = 0;
        for(int num : dp[n]) answer = (answer + num) % 10_007;

        System.out.println(answer);
    }
}
