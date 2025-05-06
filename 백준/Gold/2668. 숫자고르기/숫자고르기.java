import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    private static int[] arr;
    private static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기
        int n = Integer.parseInt(br.readLine());

        // 문제 풀이용 배열 선언
        arr = new int[n+1];
        vis = new boolean[n+1];

        // 배열 초기화
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        // 탐색
        PriorityQueue<Integer> answer = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if(vis[i]) continue;

            Set<Integer> hist = new HashSet<>();
            dfs(i, arr[i], hist);

            for (Integer node : hist) {
                vis[node] = true;
                answer.offer(node);
            }
        }

        System.out.println(answer.size());
        while(!answer.isEmpty()) System.out.println(answer.poll());
    }

    public static void dfs(int start, int curr, Set<Integer> hist) {

        // 시작 노드로 돌아왔다면 재귀 종료
        if(start == curr) {
            hist.add(start);
            return;
        }

        // 이미 방문한 노드인 경우 방문 기록을 지우고 재귀 종료
        if(hist.contains(curr)) {
            hist.clear();
            return;
        }

        hist.add(curr);
        dfs(start, arr[curr], hist);
    }
}