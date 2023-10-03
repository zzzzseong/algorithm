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

        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i-1] + array[i]);
            dp[i] = Math.max(dp[i], array[i]);
        }

        int max = -1000;
        for (int i = 0; i <dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i]);
//        }
//        System.out.println("====================");
        System.out.println(max);
//        System.out.println("====================");
    }
}