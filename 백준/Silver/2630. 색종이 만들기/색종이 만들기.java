import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BAEKJOON */
public class Main {
    private static int N;
    private static int[][] map;

    private static int blue = 0;
    private static int white = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        
        dfs(0, N, 0, N, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dfs(int sx, int ex, int sy, int ey, int depth) {
        if(depth == 1 || isColorPaper(sx, ex, sy, ey)) {
            if(map[sx][sy] == 0) white++;
            if(map[sx][sy] == 1) blue++;
            return;
        }

        dfs(sx, (sx+ex)/2, sy, (sy+ey)/2, depth/2);
        dfs((sx+ex)/2, ex, sy, (sy+ey)/2, depth/2);

        dfs(sx, (sx+ex)/2, (sy+ey)/2, ey, depth/2);
        dfs((sx+ex)/2, ex, (sy+ey)/2, ey, depth/2);
    }

    public static boolean isColorPaper(int sx, int ex, int sy, int ey) {
        int color = map[sx][sy];
        for(int i=sx; i<ex; i++) {
            for (int j=sy; j<ey; j++) {
                if(map[i][j] != color) return false;
            }
        }

        return true;
    }
}