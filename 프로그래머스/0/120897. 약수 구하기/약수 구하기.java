import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> list = new ArrayList<>();
        
        double sqrt = Math.sqrt(n);
        
        int i;
        for(i=1; i<sqrt; i++) {
            if(n%i != 0) continue;
            
            list.add(i);
            list.add(n/i);
        }
        
        if(i==sqrt) list.add(i);
        
        int[] answer = list.stream().mapToInt(l->l).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}