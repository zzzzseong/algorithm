import java.util.*;

class Solution {

    private int[] parent;

    public void init(int n, int[][] costs) {

        //union-find algorithm 사용을 위한 자료구조 초기화
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        //greedy algorithm 사용을 위한 간선 가중치 기준 정렬
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2]-o2[2];
        });
    }

    public int solution(int n, int[][] costs) {
        init(n, costs);

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int px = find(costs[i][0]);
            int py = find(costs[i][1]);

            //이미 연결된 정점이라면
            if(px == py) continue;

            union(px, py);
            answer +=costs[i][2];
        }

        return answer;
    }

    public void union(int px, int py) {
        if(px <= py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    public int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
}