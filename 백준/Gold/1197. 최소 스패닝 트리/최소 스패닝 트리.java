import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[][] graph;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);

        graph = new int[E][3];
        for (int i = 0; i < E; i++) {
            String[] ABC = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(ABC[0]);
            graph[i][1] = Integer.parseInt(ABC[1]);
            graph[i][2] = Integer.parseInt(ABC[2]);
        }
        Arrays.sort(graph, (o1, o2)-> {
            return o1[2]-o2[2];
        });

        parent = new int[V+1];
        for (int i = 1; i < parent.length; i++) parent[i] = i;

        int answer = 0;
        for (int i = 0; i < graph.length; i++) {
            int px = find(graph[i][0]);
            int py = find(graph[i][1]);

            if(px == py) continue;

            union(px, py);
            answer += graph[i][2];
        }

        System.out.println(answer);
    }

    public static void union(int px, int py) {
        if(px >= py) parent[py] = px;
        else parent[px] = py;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}