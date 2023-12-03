import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*BAEKJOON */
public class Main {
    private static int N, K;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        init();

        long answer = 0;
        long left = 1;
        long right = K;
        while(left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for(int i=1; i<=N; i++) {
                count += Math.min(mid/i, N);
            }

            if(count >= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}