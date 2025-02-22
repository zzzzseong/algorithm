import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> schedules = new PriorityQueue<>((o1, o2) -> {
            if(o1[1]==o2[1]) return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });

        for (int i = 0; i < n; i++) {
            String[] schedule = br.readLine().split(" ");
            schedules.offer(new int[]{Integer.parseInt(schedule[0]), Integer.parseInt(schedule[1])});
        }

        int end = 0;
        while(!schedules.isEmpty()) {
            int[] schedule = schedules.poll();
            if(schedule[0] >= end) {
                answer++;
                end = schedule[1];
            }
        }

        System.out.println(answer);
    }
}