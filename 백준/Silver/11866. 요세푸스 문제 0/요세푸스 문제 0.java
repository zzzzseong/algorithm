import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N; i > 0; i--) {
            deque.addFirst(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!deque.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                deque.addLast(deque.removeFirst());
            }

            sb.append(deque.removeFirst()).append(", ");
        }

        System.out.println(sb.substring(0, sb.length()-2) + ">");
    }
}