import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static int R, C;

    private static char[][] map;

    private static int l1x, l1y, l2x, l2y;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static Deque<int[]> searchQ = new ArrayDeque<>();
    private static Deque<int[]> meltQ = new ArrayDeque<>();
    private static boolean[][] vis;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] RC = br.readLine().split(" ");

        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        map = new char[R][C];
        boolean sign = false;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'L') {
                    if(!sign) {
                        l1x = i; l1y = j;
                        sign = true;
                    } else {
                        l2x = i; l2y = j;
                    }

                    map[i][j] = '.';
                }

                if(map[i][j] == '.') meltQ.addLast(new int[]{i, j});
            }
        }

        vis = new boolean[R][C];
    }

    public static void main(String[] args) throws IOException {
        init();

        //초기 좌표 설정
        searchQ.addLast(new int[]{l1x, l1y});

        int day = 0;
        while(!move()) {
            melt();
            day++;
        }

        System.out.println(day);
    }

    public static boolean move() {
        Deque<int[]> nq = new ArrayDeque<>();

        while(!searchQ.isEmpty()) {
            int[] curPos = searchQ.removeFirst();

            if(curPos[0] == l2x && curPos[1] == l2y) return true;

            for (int[] d : dir) {
                int nx = curPos[0] + d[0];
                int ny = curPos[1] + d[1];

                if(nx >= R || nx < 0 || ny >= C || ny < 0) continue;
                if(vis[nx][ny]) continue;

                vis[nx][ny] = true;
                if(map[nx][ny] == 'X') nq.addLast(new int[]{nx, ny});
                else searchQ.addLast(new int[]{nx, ny});
            }
        }

        searchQ = nq;

        return false;
    }

    public static void melt() {
        int len = meltQ.size();

        for (int i = 0; i < len; i++) {
            int[] pos = meltQ.removeFirst();

            for (int[] d : dir) {
                int nx = pos[0] + d[0];
                int ny = pos[1] + d[1];

                if (nx >= R || nx < 0 || ny >= C || ny < 0) continue;

                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    meltQ.addLast(new int[]{nx, ny});
                }
            }
        }
    }

}