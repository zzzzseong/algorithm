import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int N, L, R;
    private static int[][] nations;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int totalPopulation, numberOfNation;
    private static boolean isMigrated;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NLR = br.readLine().split(" ");
        N = Integer.parseInt(NLR[0]);
        L = Integer.parseInt(NLR[1]);
        R = Integer.parseInt(NLR[2]);

        nations = new int[N][N];
        for (int i = 0; i < N; i++) {
            nations[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        int day = 0;
        while(true) {
            boolean[][] vis = new boolean[N][N];
            boolean goToNextDay = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!vis[i][j]) {
                        totalPopulation = 0;
                        numberOfNation = 0;
                        isMigrated = false;
                        Set<int[]> nationSet = new HashSet<>();

                        dfs(i, j, vis, nations[i][j], nationSet);

                        if(isMigrated) {
                            goToNextDay = true;

                            // 평균 인구수로 최신화
                            int avgPopulation = totalPopulation/numberOfNation;
                            for (int[] pos : nationSet) nations[pos[0]][pos[1]] = avgPopulation;
                        }
                    }
                }
            }

            if(!goToNextDay) break;
            else day++;
        }

        System.out.println(day);
    }

    public static void dfs(int x, int y, boolean[][] vis, int firstPopulation, Set<int[]> nationSet) {
        vis[x][y] = true;
        totalPopulation += nations[x][y];
        numberOfNation++;
        if(nations[x][y] != firstPopulation) isMigrated = true;
        nationSet.add(new int[]{x, y});

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
            if(vis[nx][ny]) continue;

            int abs = Math.abs(nations[x][y]-nations[nx][ny]);
            if(abs < L || abs > R) continue;

            dfs(nx, ny, vis, firstPopulation, nationSet);
        }
    }
}