import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 가장 큰 증가하는 부분 수열
 * 수열의 크기 1 <= n <= 1,000
 * seq = 1, 101, 101, 101, 113, 113, 113, 133, 113, 113
 * dp = 1, 101, 3, 53, 113, 6, 11, 17, 24, 32
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = seq[i];

            int max = 0;
            for(int j=i-1; j>=0; j--) {
                // 근데 이게 또 뒤로가다가 seq[i]가 100이고 보다 다음으로 작은 값은 3인데,
                // 그 뒤에 99가 있으면 예외 발생 - 결국 0번째까지 풀스캔 해야하는 문제가 발생
                if(seq[j] < seq[i]) max = Math.max(max, dp[j]);
            }

            dp[i] += max;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}