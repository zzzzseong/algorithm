import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        boolean[] vis = new boolean[100_001];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, n});

        while(!dq.isEmpty()) {
            int[] pos = dq.poll();
            vis[pos[1]] = true;

            if(pos[1] == k) {
                System.out.println(pos[0]);
                break;
            }

            int time = pos[0]+1;

            if(pos[1]*2 <= 100_000 && !vis[pos[1]*2]) dq.offer(new int[]{time, pos[1]*2});

            if(pos[1]+1 <= 100_000 && !vis[pos[1]+1]) dq.offer(new int[]{time, pos[1]+1});

            if(pos[1]-1 >= 0 && !vis[pos[1]-1]) dq.offer(new int[]{time, pos[1]-1});
        }
    }
}