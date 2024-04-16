import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] seq = new int[N];

        for (int i = 0; i < N; i++) seq[i] = Integer.parseInt(br.readLine());

        Arrays.sort(seq);

        long answer = Long.MAX_VALUE;

        int right = 1;
        for (int left = 0; left < N; left++) {
            int l = seq[left];

            while(right < N && seq[right]-l < M) right++;

            if(right == N) break;

            answer = Math.min(answer, seq[right]-l);
        }

        System.out.println(answer);
    }
}