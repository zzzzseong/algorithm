import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static int N;
    private static Integer[] A, B;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arrA[i]);
            B[i] = Integer.parseInt(arrB[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i]*B[i];
        }

        System.out.println(answer);
    }
}