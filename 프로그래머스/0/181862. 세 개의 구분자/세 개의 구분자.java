import java.util.*;

class Solution {
    
    private final PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    private final List<String> list = new ArrayList<>();
    
    public String[] solution(String myStr) {
        
        for(int i=0; i<myStr.length(); i++) {
            char c = myStr.charAt(i);
            if('a' == c || 'b' == c || 'c' == c) pq.offer(i);
        }
        
        if(pq.isEmpty()) {
            String[] answer = {myStr};
            return answer;
        }
                
        int cur = pq.poll();
        if(0 != cur) list.add(myStr.substring(0, cur));    
        
        while(!pq.isEmpty()) {
            int n = pq.poll();
            
            if(cur+1 != n) list.add(myStr.substring(cur+1, n));
            
            cur = n;
        }
        
        if(cur+1 != myStr.length()) list.add(myStr.substring(cur+1, myStr.length()));
     
        if(list.isEmpty()) {
            String[] answer = {"EMPTY"};
            return answer;
        }
        
        return list.stream().toArray(String[]::new);
    }
}