import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double sum = 0;

        PriorityQueue<Double> pq = new PriorityQueue<>();
        PriorityQueue<Double> pq2 = new PriorityQueue<>();

        Map<Double, Integer> map = new HashMap<>();
        int maxCount = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            double n = Integer.parseInt(br.readLine());

            sum += n;

            pq.offer(n);

            if(map.get(n) == null) map.put(n, 0);

            int count = map.get(n);
            if(count+1 > maxCount) {
                maxCount = count+1;
            }

            map.put(n, count+1);

            max = Math.max(max, (int) n);
            min = Math.min(min, (int) n);
        }

        //1. 산술평균
        System.out.println(Math.round(sum/N));

        //2. 중앙값
        for (int i = 0; i < N / 2; i++) {
            pq.poll();
        }
        System.out.println(pq.poll().intValue());

        //3. 최빈값
        for (Double key : map.keySet()) {
            if(map.get(key) == maxCount) {
                pq2.offer(key);
            }
        }
        if(pq2.size() >= 2) pq2.poll();
        System.out.println(pq2.poll().intValue());

        //4. 범위
        System.out.println(max - min);
    }
}