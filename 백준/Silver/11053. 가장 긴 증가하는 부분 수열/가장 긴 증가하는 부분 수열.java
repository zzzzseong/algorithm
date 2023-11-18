import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*BAEKJOON */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(array[j] < array[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            if(max == 0) dp[i] = 1;
            else dp[i] = max+1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}

//반례1. 2 5 4 10 6 15 8 10