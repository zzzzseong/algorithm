import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        List<Set<Integer>> ls = new ArrayList<>();
        ls.add(new HashSet<>());
        ls.get(0).add(x);
        
        int idx = 1;
        boolean canCal = true;
        
        LOOP1:
        while(canCal) {
            canCal = false;
            
            ls.add(new HashSet<>());
            
            Set<Integer> set = ls.get(idx-1);
            
            for(int num : set) {
                int n1 = num + n;
                int n2 = num * 2;
                int n3 = num * 3;
                
                if(n1 < y || n2 < y || n3 < y) canCal = true;
                if(n1 == y || n2 == y || n3 == y) break LOOP1;
                
                ls.get(idx).add(n1);
                ls.get(idx).add(n2);
                ls.get(idx).add(n3);
            }
        
            idx++;
            
            if(!canCal) return -1;
        }
            
        return idx;
    }
}