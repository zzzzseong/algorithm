import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BAEKJOON */
public class Main {
    private static int N;
    private static int[] vis;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        vis = new int[N];

        nQueen(0);
        System.out.println(answer);
    }

    //dfs function
    public static void nQueen(int depth) {
        if(depth >= N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            vis[depth] = i;
            if(marking(depth)) nQueen(depth + 1);

        }
    }

    public static boolean marking(int depth) {
        for (int i = 0; i < depth; i++) {
            //직선상 공격 가능
            if(vis[i] == vis[depth]) return false;

            //대각선상 공격 가능 -> 열의 차와 행의 차가 같은 경우
            if(Math.abs(depth - i) == Math.abs(vis[depth] - vis[i])) return false;
        }
        return true;
    }
}