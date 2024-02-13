import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static long answer = 0;

    private static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = seq[0];
        for (int i = 1; i < seq.length; i++) {
            max = Math.max(max, seq[i]);
        }

        binarySearch(seq, 0, (max)/2, max);

        System.out.println(answer);
    }

    public static void binarySearch(int[] seq, int s, int m, int e) {
        long sum = 0;
        for (int j : seq) {
            if (j - m > 0)
                sum += j - m;
        }

        if(sum == K) {
            answer = m;
            return;
        }

        if(sum > K) {
            answer = Math.max(answer, m);

            if(m == (m+e)/2) return;

            //높이 올리기
            binarySearch(seq, m, (m+e)/2, e);
        } else {
            if(m == (s+m)/2) return;

            //높이 내리기
            binarySearch(seq, s, (s+m)/2, m);
        }
    }
}