import java.util.*;

class Solution {
    public void init(String[][] plans) {
        for(int i=0; i<plans.length; i++) {
            String[] time = plans[i][1].split(":");
            
            plans[i][1] = String.valueOf(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
        }
        
        Arrays.sort(plans, (p1, p2) -> {
            int t1 = Integer.parseInt(p1[1]);
            int t2 = Integer.parseInt(p2[1]);
            
            return t1-t2;
        });
    }
    
    public String[] solution(String[][] plans) {
        init(plans);
                
        Stack<String[]> stack = new Stack<>();
        
        int idx = 0;
        String[] answer = new String[plans.length];
        
        int et = Integer.parseInt(plans[0][1]) + Integer.parseInt(plans[0][2]);
        for(int i=1; i<plans.length; i++) {
            int st = Integer.parseInt(plans[i][1]);
            
            if(et > st) {
                //이전 작업의 종료시간이 현재 작업의 시작시간보다 크다면
                String[] p = {plans[i-1][0], String.valueOf(et-st)};
                stack.push(p);
            } else if(et == st) {
                //이전 작업의 종료시간과 현재 작업의 시작시간이 같다면
                answer[idx++] = plans[i-1][0];
            } else {
                //이전 작업의 종료시간이 현재 작업의 시작시간보다 작다면
                answer[idx++] = plans[i-1][0];
                
                int rt = st-et;
                
                while(true) {
                    if(stack.isEmpty()) break;
                    
                    String[] s = stack.pop();
                    
                    int remain = Integer.parseInt(s[1]);
                    
                    if(remain > rt) {
                        s[1] = String.valueOf(remain-rt);
                        stack.push(s);
                        break;
                    } else if(remain == rt) {
                        answer[idx++] = s[0];
                        break;
                    } else {
                        answer[idx++] = s[0];
                        rt -= remain;
                    }
                }
            }
            et = Integer.parseInt(plans[i][1]) + Integer.parseInt(plans[i][2]);
        
            if(i==plans.length-1) answer[idx++] = plans[i][0];
        }
        
        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop()[0];
        }
        
        return answer;
    }
}