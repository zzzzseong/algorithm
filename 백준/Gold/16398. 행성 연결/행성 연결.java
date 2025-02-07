import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /* 행성i, 행성j 사이 연결 비용 저장 배열 */
        List<int[]> costs = new ArrayList<>();

        /* union-find를 위한 최상위 부모노드 저장 배열 */
        parent = new int[n];

        for(int i=0; i<n; i++) {
            int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=i+1; j<n; j++) costs.add(new int[]{i, j, cost[j]});
            parent[i] = i;
        }

        costs.sort((o1, o2) -> o1[2]-o2[2]);

        long answer = 0;
        for (int[] cost : costs) {
            if(union(cost[0], cost[1])) answer += cost[2];
        }

        System.out.println(answer);
    }

    public static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        /* 탐색 시간 절약 용 */
        parent[x] = px;
        parent[y] = py;

        /* 이미 연결된 노드 */
        if(px == py) return false;

        if(px <= py) parent[py] = px;
        else parent[px] = py;

        return true;
    }

    public static int find(int node) {
        if(node == parent[node]) return node;
        return find(parent[node]);
    }
}
