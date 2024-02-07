import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] dp = new int[size + 1];
        int[] stairs = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int answer = process(size, dp, stairs);
        System.out.println(answer);
    }

    public static int process(int size, int[] dp, int[] stairs) {

        dp[1] = stairs[1];
        if(size >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= size; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        return dp[size];
    }
}