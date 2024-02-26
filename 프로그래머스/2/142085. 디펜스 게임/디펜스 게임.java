import java.util.*;

class Solution {
    
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int solution(int n, int k, int[] enemy) {
        
        int idx = 0;
        while(true) {
            if(idx == enemy.length) break;
            
            int e = enemy[idx++];
            pq.offer(e);
            
            if(n >= e) {
                // 무적권 사용 없이 n이 e보다 큰 경우
                n -= e;
            } else {
                boolean pass = false;
                while(k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                    
                    // k를 이용해 라운드 통과
                    if(n >= e) {
                        n -= e;
                        pass = true;
                        break;
                    }
                }
                
                //k를 이용해 round pass가 불가능하다면 (k가 0이거나 pq가 비어있어 k를 소모할 수 없는 경우)
                if(!pass) {
                    return idx-1;
                }
            }
        }
        
        return idx;
    }
}