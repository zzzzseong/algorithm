import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] counts = new int[10_000_001];
        
        //100_000
        for(int t : tangerine) {
            counts[t]++;
        }
        
        //10_000_001 * log (10_000_001)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : counts) {
            if(c == 0) continue;
            pq.offer(c);
        }
        
        int sum = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
            answer++;
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}