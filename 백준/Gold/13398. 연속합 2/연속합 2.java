import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*BAEKJOON */
public class Main {
    private static int n;
    private static int[] sequence;
    private static int[] dp;
    private static int[] dp2;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(getAnswer());
    }

    public static int getAnswer() {

        //init dp, dp2

        dp[1] = sequence[1];
        dp2[n] = sequence[n];
        int max = dp[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + sequence[i], sequence[i]);
            max = Math.max(max, dp[i]);
        }

        for(int i = n-1; i >= 1; i--) {
            dp2[i] = Math.max(dp2[i+1] + sequence[i], sequence[i]);
        }

/*        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : dp2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println(max);*/

        //remove check
        for (int i = 2; i < n; i++) {
            int temp = dp[i-1] + dp2[i+1];
            max = Math.max(max, temp);
        }

        return max;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sequence = new int[n+1];

        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++) {
            sequence[i] = seq[i-1];
        }

        dp = new int[n+1];
        dp2 = new int[n+1];
    }
}