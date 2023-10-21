import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*BAEKJOON */
public class Main {
    private static int N, M;

    private static int[][] map;
    private static Set<int[]> positionOfVirus;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 1 && map[i][j] != 2) {
                    map[i][j] = 1;
                    buildSecondWall(i, j);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    public static void buildSecondWall(int i, int j) {
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < M; l++) {
                if(map[k][l] != 1 && map[k][l] != 2) {
                    map[k][l] = 1;
                    buildThirdWall(k, l);
                    map[k][l] = 0;
                }
            }
        }
    }

    public static void buildThirdWall(int k, int l) {
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if(map[a][b] != 1 && map[a][b] != 2) {
                    map[a][b] = 1;
                    updateResult();
                    map[a][b] = 0;
                }
            }
        }
    }

    public static void updateResult() {
        int[][] spreadArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                spreadArr[i][j] = map[i][j];
            }
        }

        for (int[] position : positionOfVirus) {
            spread(spreadArr, position[0], position[1]);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(spreadArr[i][j] == 0) count++;
            }
        }

        answer= Math.max(answer, count);
    }

    public static void spread(int[][] spreadArr, int i, int j) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
            if(spreadArr[nx][ny] != 0) continue;

            spreadArr[nx][ny] = 2;
            spread(spreadArr, nx, ny);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        map = new int[N][M];
        positionOfVirus = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if(map[i][j] == 2) {
                    int[] position = {i, j};
                    positionOfVirus.add(position);
                }
            }
        }
    }
}