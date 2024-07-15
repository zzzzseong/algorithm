import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    public static int solution(int N) {
        if(N%2 != 0) return 0;

        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i < dp.length; i+=2) {
            dp[i] = dp[i-2]*3;

            for (int j = i-4; j >=0; j-=2) {
                dp[i] += dp[j]*2;
            }
        }

        return dp[N];
    }
}