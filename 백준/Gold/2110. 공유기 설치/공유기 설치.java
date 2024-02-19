import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N, C;
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int[] house = new int[N];

        int idx = 0;
        while(!pq.isEmpty()) {
            house[idx++] = pq.poll();
        }

        int lo = 1;
        int hi = house[house.length-1] - house[0];

        if(C > 2) {
            binarySearch(house, lo, hi);
            System.out.println(answer);
        } else {
            System.out.println(hi);
        }
    }

    public static void binarySearch(int[] house, int lo, int hi) {
        while(hi > lo) {

            int mid = (lo+hi)/2;

            int curC = 1;
            int curIdx = 0;
            for (int i = 1; i < house.length; i++) {
                if(house[i]-house[curIdx] >= mid) {
                    curC++;
                    curIdx = i;
                }
            }

            if(curC >= C) {
                lo = mid+1;
                answer = Math.max(answer, mid);
            } else {
                hi = mid;
            }
        }
    }
}