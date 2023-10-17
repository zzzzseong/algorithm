import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*BAEKJOON */
public class Main {
    private static final PriorityQueue<Integer> minH = new PriorityQueue<>();
    private static final PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

    private static int N;

    public static void main(String[] args) throws Exception {
        System.out.println(getAnswer());
    }

    public static String getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        maxH.add(Integer.parseInt(br.readLine()));
        sb.append(maxH.peek()).append("\n");

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                if(num > minH.peek()) {
                    maxH.add(minH.poll());
                    minH.add(num);
                } else {
                    maxH.add(num);
                }
            } else {
                if(num < maxH.peek()){
                    minH.add(maxH.poll());
                    maxH.add(num);
                } else {
                    minH.add(num);
                }
            }
            sb.append(maxH.peek()).append("\n");
        }
        return sb.toString();
    }
}