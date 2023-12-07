import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int[] priorities, int location) {
        for(int p : priorities) {
            pq.offer(p);
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    
                    if(location == i) return answer;
                }
            }
        }
        
        return answer;
    }
}