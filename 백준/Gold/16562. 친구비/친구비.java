import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static int N, M, k;
    private static int min = Integer.MAX_VALUE;

    private static int[] cost;
    private static boolean[] vis;

    private static final List<Set<Integer>> graph = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        cost = new int[N+1];
        vis = new boolean[N+1];

        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < line2.length; i++) {
            cost[i+1] = Integer.parseInt(line2[i]);
        }

        graph.add(null);
        for (int i = 1; i <= N; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            String[] e = br.readLine().split(" ");

            int A = Integer.parseInt(e[0]);
            int B = Integer.parseInt(e[1]);

            graph.get(A).add(B);
            graph.get(B).add(A);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean can = true;

        int answer = 0;
        for (int i = 1; i < vis.length; i++) {

            //방문하지 않은 node라면
            if(!vis[i]) {
                spread(i);

                if(k >= min) {
                    k -= min;
                    answer += min;
                    min = Integer.MAX_VALUE;
                } else {
                    can = false;
                    break;
                }
            }
        }

        if(!can) {
            System.out.println("Oh no");
        } else {
            System.out.println(answer);
        }
    }

    public static void spread(int idx) {
        vis[idx] = true;

        min = Math.min(min, cost[idx]);

        Set<Integer> set = graph.get(idx);

        for (Integer s : set) {
            if(vis[s]) continue;

            spread(s);
        }
    }
}