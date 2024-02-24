import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;

    private static int[][] colors;

    private static final int[] target = new int[3];

    private static int answer = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        colors = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            colors[i][0] = Integer.parseInt(line[0]);
            colors[i][1] = Integer.parseInt(line[1]);
            colors[i][2] = Integer.parseInt(line[2]);
        }

        String[] line = br.readLine().split(" ");
        target[0] = Integer.parseInt(line[0]);
        target[1] = Integer.parseInt(line[1]);
        target[2] = Integer.parseInt(line[2]);
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < colors.length; i++) {
            combination(i+1, 1, colors[i][0], colors[i][1], colors[i][2]);
        }

        System.out.println(answer);
    }

    public static void combination(int sIdx, int r, int R, int G, int B) {
        if(r == N || r == 7) {
            return;
        }

        for (int i = sIdx; i < colors.length; i++) {
            int nR = R + colors[i][0];
            int nG = G + colors[i][1];
            int nB = B + colors[i][2];

            answer = Math.min(answer, Math.abs(nR/(r+1)-target[0]) + Math.abs(nG/(r+1)-target[1]) + Math.abs(nB/(r+1)-target[2]));

            combination(i+1, r+1, nR, nG, nB);
        }
    }
}