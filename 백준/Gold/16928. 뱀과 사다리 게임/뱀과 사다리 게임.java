import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * fail(0%)  #1. 이동하려는 범위에 사다리가 두개 이상 있거나, 이동하려는 범위 밖에 더 큰 이득을 얻는 사다리가 있을 경우 대비X
 * fail(21%) #2. ???
 * */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n+m; i++) {
            String[] xy = br.readLine().split(" ");
            map.put(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        }

        boolean[] vis = new boolean[101];
        vis[1] = true;

        //pos(현재위치), move(이동횟수)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{1, 0});

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();
            int pos  = cur[0];
            int move = cur[1];

            int next = pos;

            for(int i=pos+6; i>=pos; i--) {
                Integer value = map.get(i);
                if(value == null) {
                    next = Math.max(next, i);
                    continue;
                }

                // #1 사다리가 있고, 주사위를 굴려 갈 수 있는 위치 보다 멀리갈 수 있다면
                if(value > i && value > next && !vis[value]) {
                    vis[value] = true;
                    pq.offer(new int[]{value, move+1});
                }

                // #2 이동 가능한 최대 위치에 뱀이 있다면
                if(value < i && !vis[value]) {
                    vis[value] = true;
                    pq.offer(new int[]{value, move+1});
                }
            }

            if(next >= 100) {
                System.out.println(move+1);
                break;
            }
            if(!vis[next]) {
                vis[next] = true;
                pq.offer(new int[]{next, move+1});
            }
        }
    }
}