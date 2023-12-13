import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*BAEKJOON */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];

        String[] l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(l[i]);
        }

        Arrays.sort(line);

        int sum = 0;
        int total = 0;
        for (int i = 0; i < line.length; i++) {
            total += line[i];
            sum += total;
        }

        System.out.println(sum);
    }
}