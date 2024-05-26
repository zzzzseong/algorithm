import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int a : A) pq.offer(a);
        for (int b : B) pq.offer(b);

        StringBuilder sBuilder = new StringBuilder();

        while(!pq.isEmpty()) {
            sBuilder.append(pq.poll()).append(" ");
        }

        System.out.println(sBuilder);
    }
}