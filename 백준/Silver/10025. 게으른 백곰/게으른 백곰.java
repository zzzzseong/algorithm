import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버3 - 게으른 백곰 (슬라이딩 윈도우)
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]), K = Integer.parseInt(line[1]);

        int[] arr = new int[1_000_001];
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            String[] e = br.readLine().split(" ");

            arr[Integer.parseInt(e[1])] = Integer.parseInt(e[0]);
            maxIdx = Math.max(maxIdx, Integer.parseInt(e[1]));
        }

        int answer = 0;
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i <= K * 2; i++) {
            if(i == arr.length) {
                flag = false;
                break;
            }

            sum+= arr[i];
        }

        if(!flag) {
            System.out.println(sum);
        } else {
            answer = Math.max(answer, sum);

            for (int i = K+1; i <= maxIdx-K; i++) {
                sum -= arr[i-K-1];
                sum += arr[i+K];

                answer = Math.max(answer, sum);
            }

            System.out.println(answer);
        }
    }
}
