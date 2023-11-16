import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BAEKJOON */
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[][] map;
    private static boolean[][] vis;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int T, M, N;


    public static void init() throws IOException {
        String[] firstLine = br.readLine().split(" ");

        M = Integer.parseInt(firstLine[0]);
        N = Integer.parseInt(firstLine[1]);

        map = new int[N][M];
        vis = new boolean[N][M];

        int t = Integer.parseInt(firstLine[2]);
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            map[y][x] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            init();
            sb.append(search()).append("\n");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static int search() {
        int answer = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !vis[i][j]) {
                    answer++;
                    spread(i, j);
                }
            }
        }
        return answer;
    }

    public static void spread(int x, int y) {
        vis[x][y] = true;

        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny]==1 && !vis[nx][ny]) {
                spread(nx, ny);
            }
        }
    }
}