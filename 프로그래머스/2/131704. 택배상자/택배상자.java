import java.util.*;

class Solution {
    private Stack<Integer> truck = new Stack<>();
    private Stack<Integer> sub = new Stack<>();
    
    public int solution(int[] order) {
        for(int i=order.length; i>=1; i--) {
            truck.push(i);
        }
        
        int idx = 0;
        int answer = 0;
        
        while(idx < order.length) {
            if(!truck.isEmpty()) {
                if(truck.peek() == order[idx]) {
                    truck.pop();
                    answer++;
                    idx++;
                    
                    continue;
                }
                
                //sub로 옮겨야하는 경우
                if(truck.peek() < order[idx]) {
                    sub.push(truck.pop());
                    
                    continue;
                }
                
                //sub에서 찾아야하는 경우
                if(truck.peek() > order[idx]) {
                    if(sub.peek() != order[idx]) break;
                    else {
                        sub.pop();
                        answer++;
                        idx++;
                    }
                    
                    continue;
                }
            }
            else {
                if(sub.peek() != order[idx]) break;
                else {
                    sub.pop();
                    answer++;
                    idx++;
                }
            }
        }

        return answer;
    }
}