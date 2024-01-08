import java.util.*;

class Solution {
    public int solution(int storey) {        
        String[] arr = Integer.toString(storey).split("");
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++) {
            q.addFirst(Integer.parseInt(arr[i]));
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            int num = q.removeFirst();
                        
            if(num >= 10) {
                up(q);
                num -= 10;
            }
            
            if(num > 5) {
                answer += 10-num;
                up(q);
            }
            if(num == 5) {
                if(!q.isEmpty() && q.peekFirst() >= 5) {
                    answer += 10-num;
                    up(q);
                } else {
                    answer += num;
                }
            }
            if(num < 5) {
                answer += num;
            }
        }
        
        return answer;
    }
    
    public void up(Deque<Integer> q) {
        if(q.isEmpty()) {
            q.addFirst(1);
        } else {
            q.addFirst(q.removeFirst() + 1);
        }
    }
}