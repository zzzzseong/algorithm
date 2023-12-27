import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버4 - 수들의 합 2
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] seq = new int[N];
        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < elements.length; i++) {
            seq[i] = Integer.parseInt(elements[i]);
        }

        int answer = 0;
        int sum = 0;
        for (int left = 0, right = 0; left < elements.length; left++) {
            while(sum < M && right < elements.length) sum += seq[right++];

            if(sum == M) answer++;

            sum -= seq[left];
        }
        
        System.out.println(answer);
    }
}
