import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*BAEKJOON */
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Integer> answer = new ArrayList<>();
    private static int N;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1 ,1};

    private static int[][] map;
    private static boolean[][] vis;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        search();

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer size : answer) {
            System.out.println(size);
        }
    }

    public static void search() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !vis[i][j]) answer.add(spread(0, i, j) + 1);
            }
        }
    }

    public static int spread(int sum, int x, int y) {
        vis[x][y] = true;

        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(!vis[nx][ny] && map[nx][ny] == 1) sum += spread(1, nx, ny);
        }

        return sum;
    }
}