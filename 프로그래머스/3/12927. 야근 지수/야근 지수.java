import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<works.length; i++) pq.offer(works[i]);
        
        while(n-- > 0) {
            if(pq.isEmpty()) return 0;
            
            int work = pq.poll()-1;
                        
            if(work > 0) pq.offer(work);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) Math.pow(work, 2);
        }
        
        return answer;
    }
}