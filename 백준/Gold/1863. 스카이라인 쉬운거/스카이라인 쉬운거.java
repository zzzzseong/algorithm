import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] skyLines = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] skyLine = br.readLine().split(" ");
            skyLines[i][0] = Integer.parseInt(skyLine[0]);
            skyLines[i][1] = Integer.parseInt(skyLine[1]);
        }

        Arrays.sort(skyLines, Comparator.comparingInt(s -> s[0]));

        int currHeight = skyLines[0][1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(currHeight);

        int answer = 0;
        for (int i = 1; i < n; i++) {
            int y = skyLines[i][1];

            // 고도가 낮아지는 경우
            if(currHeight > y) {
                while(!pq.isEmpty() && pq.peek() > y) {
                    pq.poll();
                    answer++;
                }

                if(pq.isEmpty() || pq.peek() != y) pq.offer(y);
            } else {
                pq.offer(y);
            }

            currHeight = y;
        }

        pq.remove(0);
        System.out.println(answer + pq.size());
    }
}