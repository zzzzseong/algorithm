import java.util.*;

class Solution {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    private long sum1 = 0;
    private long sum2 = 0;
    
    
    private void init(int[] queue1, int[] queue2) {
        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++) {
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
    }
    
    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        
        //각 큐의 원소 합을 같게 만들 수 없는 경우 -1;
        int cnt = 0;
        while(true) {
            if(sum1 > sum2) {
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n;
                sum2 += n;
            } else if(sum2 > sum1) {
                int n = q2.poll();
                q1.offer(n);
                sum2 -= n;
                sum1 += n;
            } else {
                break;
            }
            
            cnt++;
            if(cnt >= 600_000) return -1;
        }
        
        return cnt;
    }
}