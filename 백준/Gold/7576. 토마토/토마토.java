import java.io.*;
import java.util.*;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int X, Y;
    public static int[][] maps;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        X = ints[1];
        Y = ints[0];

        maps = new int[X][Y];
        for (int i = 0; i < X; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < Y; j++) {
                maps[i][j] = line[j];
            }
        }

        int answer;
        if(alreadyFill()) answer = 0;
        else answer = networking();

        System.out.println(answer);
    }

    public static int networking() {
        Queue<Pair> q = new LinkedList<>();
        boolean canFill = false;
        int days = 0;

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if(maps[i][j] == 1) q.add(new Pair(i, j));
            }
        }

        while(!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(nx > (X-1) || nx < 0 || ny > (Y-1) || ny < 0) continue;
                    if(maps[nx][ny] == -1 || maps[nx][ny] == 1) continue;

                    maps[nx][ny] = 1;
                    q.add(new Pair(nx, ny));
                }
            }
            days++;

            if(isFill()) {
                canFill = true;
                break;
            }
        }

        if(canFill) return days; //모든 토마토 확장 완료
        else return -1; //확장할 수 없다면
    }

    public static boolean isFill() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if(maps[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean alreadyFill() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if(maps[i][j] != 1 && maps[i][j] != -1) return false;
            }
        }

        return true;
    }
}