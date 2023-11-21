import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*BAEKJOON */
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final List<PriorityQueue<Integer>> dfsGraph = new ArrayList<>();
    private static final List<PriorityQueue<Integer>> bfsGraph = new ArrayList<>();
    private static int N, M, V;

    private static boolean[] dfsVis;
    private static boolean[] bfsVis;
    private static int dfsDepth = 0;

    public static void init() throws IOException {
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        V = Integer.parseInt(firstLine[2]);

        dfsGraph.add(null);
        bfsGraph.add(null);
        for(int i = 1; i <= N; i++) {
            dfsGraph.add(new PriorityQueue<>());
            bfsGraph.add(new PriorityQueue<>());
        }

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);

            dfsGraph.get(A).offer(B);
            dfsGraph.get(B).offer(A);
            bfsGraph.get(A).offer(B);
            bfsGraph.get(B).offer(A);
        }

        dfsVis = new boolean[N+1];
        bfsVis = new boolean[N+1];
    }

    public static void main(String[] args) throws IOException {
        init();

        dfs(V);
        sb.append("\n");

        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int V) {
        dfsVis[V] = true;
        sb.append(V).append(" ");

        PriorityQueue<Integer> pq = dfsGraph.get(V);
        while(!pq.isEmpty()) {
            int nextNode = pq.poll();
            if (dfsVis[nextNode]) continue;
            dfs(nextNode);
        }
    }
    public static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(bfsVis[cur]) continue;
            else bfsVis[cur] = true;
            sb.append(cur).append(" ");

            PriorityQueue<Integer> pq = bfsGraph.get(cur);
            while(!pq.isEmpty()) {
                int nextNode = pq.poll();
                if(bfsVis[nextNode]) continue;
                q.offer(nextNode);
            }
        }
    }
}