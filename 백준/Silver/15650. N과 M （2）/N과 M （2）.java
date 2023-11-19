import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BAEKJOON */
public class Main {
    private static final StringBuilder sb = new StringBuilder();

    private static int[] sequence;
    private static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = i + 1;
        }

        vis = new boolean[N];
        combination(0, M);

        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static void combination(int sIdx, int r) {
        if(r == 0) {
            printComb();
            return;
        }

        for (int i = sIdx; i < sequence.length; i++) {
            vis[i] = true;
            combination(i + 1, r - 1);
            vis[i] = false;
        }
    }

    public static void printComb() {
        for (int i = 0; i < sequence.length; i++) {
            if(vis[i]) sb.append(sequence[i]).append(" ");
        }
        sb.append("\n");
    }
}