import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/*BAEKJOON */
public class Main {
    private static int R, C;
    private static int answer = 0;

    private static int[][] map;
//    private static boolean[][] vis;
//    private static char[] alphabets;
    private static boolean[] vis = new boolean[26];

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();

        vis[map[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= R || nx < 0 || ny >= C || ny < 0) continue;
            if(vis[map[nx][ny]]) continue;
//            if(vis[nx][ny]) continue;
//            if(isDuplicate(map[nx][ny])) continue;

            //set history
            vis[map[nx][ny]] = true;
//            alphabets[depth] = map[nx][ny];


            dfs(nx, ny, depth+1);

            //remove history
            vis[map[nx][ny]] = false;
//            alphabets[depth] = '0';
        }

        answer = Math.max(answer, depth);
    }

//    public static boolean isDuplicate(char alphabet) {
//        for (char a : alphabets) {
//            if(a == alphabet) return true;
//            if(a == '0') return false;
//        }
//        return false;
//    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                map[i][j] = line[j].charAt(0) - 'A';
            }
        }

//        vis = new boolean[R][C];
//        alphabets = new char[R*C];
//        Arrays.fill(alphabets, '0');
    }
}