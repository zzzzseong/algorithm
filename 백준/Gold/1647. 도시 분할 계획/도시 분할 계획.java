import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] network = new int[M][3];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");

            network[i][0] = Integer.parseInt(line[0]);
            network[i][1] = Integer.parseInt(line[1]);
            network[i][2] = Integer.parseInt(line[2]);
        }

        Arrays.sort(network, (o1, o2)-> {
            return o1[2]-o2[2];
        });

        int[] parent = new int[N+1];
        for (int i = 1; i < parent.length; i++) parent[i] = i;

        int answer = 0;
        int max = 0;
        for (int i = 0; i < network.length; i++) {
            int px = find(parent, network[i][0]);
            int py = find(parent, network[i][1]);

            if(px == py) continue;

            union(parent, px, py);
            answer += network[i][2];
            max = Math.max(max, network[i][2]);
        }
        
        System.out.println(answer-max);
    }

    public static void union(int[] parent, int px, int py) {
        if(px <= py) parent[py] = px;
        else parent[px] = py;
    }

    public static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        return find(parent, parent[x]);
    }
}