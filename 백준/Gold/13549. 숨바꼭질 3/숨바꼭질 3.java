import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        boolean[] vis = new boolean[100_001];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, n});

        while(!pq.isEmpty()) {
            int[] pos = pq.poll();
            vis[pos[1]] = true;

            if(pos[1] == k) {
                System.out.print(pos[0]);
                break;
            }

            if(pos[1]+1 <= 100_000 && !vis[pos[1]+1]) pq.offer(new int[]{pos[0]+1, pos[1]+1});
            if(pos[1]-1 >= 0 && !vis[pos[1]-1]) pq.offer(new int[]{pos[0]+1, pos[1]-1});
            if(pos[1]*2 <= 100_000 && !vis[pos[1]*2]) pq.offer(new int[]{pos[0], pos[1]*2});
        }
    }
}