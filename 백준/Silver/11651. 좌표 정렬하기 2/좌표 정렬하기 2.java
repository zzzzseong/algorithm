import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> {
            if(m1[1] == m2[1]) {
                return m1[0]-m2[0];
            }
            return m1[1]-m2[1];
        });

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            int[] e = {Integer.parseInt(line[0]), Integer.parseInt(line[1])};

            pq.offer(e);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] p = pq.poll();

            sb.append(p[0] + " " + p[1]).append("\n");
        }

        System.out.println(sb);
    }
}