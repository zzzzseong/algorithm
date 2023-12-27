import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 실버3 - 두 수의 합
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            seq[i] = Integer.parseInt(line[i]);
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(seq);
        
        int answer = 0;
        for (int left = 0, right = seq.length-1; left < seq.length; left++) {
            while(seq[left] + seq[right] > x && right > left) right--;

            if(left >= right) break;

            if(seq[left] + seq[right] == x) answer++;
        }

        System.out.println(answer);
    }
}
