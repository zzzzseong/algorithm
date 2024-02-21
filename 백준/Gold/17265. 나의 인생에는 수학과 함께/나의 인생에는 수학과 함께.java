import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;

    private static String[][] map;

    private static int[] nums;
    private static char[] op;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static final int[][] dir = {{1, 0}, {0, 1}};

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for (int i = 0; i < map.length; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = line[j];
            }
        }

        nums = new int[N];
        op = new char[N-1];
    }

    public static void main(String[] args) throws IOException {
        init();

        nums[0] = Integer.parseInt(map[0][0]);
        dfs(0, 0, 1);

        System.out.print(max + " " + min);
    }

    public static void dfs(int x, int y, int depth) {
        if(x == N-1 && y == N-1) {
            int ret = nums[0];

            for (int i = 0; i < op.length; i++) {
                if(op[i] == '+') {
                    ret += nums[i+1];
                } else if(op[i] == '-') {
                    ret -= nums[i+1];
                } else {
                    ret *= nums[i+1];
                }
            }

            max = Math.max(max, ret);
            min = Math.min(min, ret);

            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;

            //operator
            if(depth%2 != 0) op[depth/2] = map[nx][ny].charAt(0);
            else nums[depth/2] = Integer.parseInt(map[nx][ny]);

            dfs(nx, ny, depth+1);
        }
    }
}