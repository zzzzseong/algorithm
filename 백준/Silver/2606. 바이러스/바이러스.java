import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*BAEKJOON */
public class Main {
    private static int N, M;
    private static List<HashSet<Integer>> networks;
    private static boolean[] dp;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //컴퓨터 갯수
        dp = new boolean[N+1];

        M = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍의 수

        networks = new ArrayList<>();
        networks.add(null);
        for (int i = 1; i <= N; i++) {
            networks.add(new HashSet<>());
        }
        for (int i = 0; i < M; i++) {
            String[] network = br.readLine().split(" ");
            int a = Integer.parseInt(network[0]);
            int b = Integer.parseInt(network[1]);

            networks.get(a).add(b);
            networks.get(b).add(a);
        }

        spread(1);
        System.out.println(count-1);
    }

    public static void spread(int index) {
        dp[index] = true;
        count++;

        networks.get(index).forEach(i -> {
            if (!dp[i]) {
                spread(i);
            }
        });
    }
}