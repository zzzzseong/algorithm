import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final List<double[]> graph = new ArrayList<>();

    private static int[] parent;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        float[][] stars = new float[n][2];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");

            stars[i][0] = Float.parseFloat(xy[0]);
            stars[i][1] = Float.parseFloat(xy[1]);

            parent[i] = i;
        }

        for (int i = 0; i < stars.length-1; i++) {
            for (int j = i+1; j < stars.length; j++) {

                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(
                    stars[i][1] - stars[j][1], 2));

                graph.add(new double[]{i, j, dist});
            }
        }

        graph.sort(Comparator.comparingDouble(o -> o[2]));
    }

    public static void main(String[] args) throws IOException {
        init();

        double answer = 0;
        for (int i = 0; i < graph.size(); i++) {
            double[] path = graph.get(i);

            int p1 = find((int) path[0]);
            int p2 = find((int) path[1]);

            if(p1 == p2) continue;

            union(p1, p2);

            answer += path[2];
        }

        System.out.printf("%.2f", answer);
    }

    public static void union(int node1, int node2) {
        if(node1 >= node2) parent[node2] = node1;
        else parent[node1] = node2;
    }

    public static int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
}