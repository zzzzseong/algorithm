import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// start => 13:45:00
// 목표 풀이 시간: 30분
// end => 14:15:00
public class Main {

    private static int N, M, X;

    private static HashSet<int[]>[] graph;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");
        N = Integer.parseInt(NMX[0]);
        M = Integer.parseInt(NMX[1]);
        X = Integer.parseInt(NMX[2]);

        graph = new HashSet[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new HashSet();

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);
            int cost = Integer.parseInt(edge[2]);
            graph[from].add(new int[]{to, cost});
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        int maxCost = 0;

        int[] go = new int[N+1];
        for (int i = 1; i <= N; i++) go[i] = dijkstra(i)[X];

        int[] from = dijkstra(X);
        for (int i = 1; i <= N; i++) maxCost = Math.max(maxCost, go[i] + from[i]);

        System.out.println(maxCost);
    }

    public static int[] dijkstra(int start) {
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);

        while(!dq.isEmpty()) {
            int currNode = dq.poll();

            Set<int[]> nextNodes = graph[currNode];
            for (int[] nextNode : nextNodes) {
                int nextNodeNumber = nextNode[0];
                int cost = nextNode[1];

                if(dp[currNode] + cost < dp[nextNodeNumber]) {
                    dp[nextNodeNumber] = dp[currNode] + cost;
                    dq.offer(nextNodeNumber);
                }
            }
        }

        return dp;
    }
}