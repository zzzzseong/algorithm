import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        for (int i = 0; i < N; i++) seq[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int left=0; left<N-1; left++) {
            int right = left;

            while(right < N && seq[right] == seq[left]) right++;

            if(right == N) {
                answer = Math.max(answer, right-left);
                break;
            }

            int pass = seq[right];

            int sum = 0;
            for (int i = left; i < N; i++) {
                if(seq[i] == seq[left]) {
                    sum++;
                    continue;
                }
                if(seq[i] == pass) continue;
                break;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}