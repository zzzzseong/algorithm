import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*BAEKJOON */
public class Main {
    private static final PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while(pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            sum += temp1 + temp2;
            pq.add(temp1 + temp2);
        }

        System.out.println(sum);
    }
}