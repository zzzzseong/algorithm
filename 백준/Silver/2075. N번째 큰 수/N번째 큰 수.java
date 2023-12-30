import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 실버2 - N번째 큰 수
 * */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N*N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < line.length; j++) {
                seq[idx++] = Integer.parseInt(line[j]);
            }
        }

        Arrays.sort(seq);

        System.out.println(seq[seq.length-N]);
    }
}
