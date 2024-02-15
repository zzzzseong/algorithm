import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=l; i<=r; i++) {
            String v = String.valueOf(i);
            
            boolean push = true;
            for(int j=0; j<v.length(); j++) {
                if(v.charAt(j) != '5' && v.charAt(j) != '0') {
                    push = false;
                    break;
                }
            }
            
            if(push) list.add(i);
        }
        if(list.isEmpty()) {
            int[] ret = {-1};
            return ret;
        } else {
            return list.stream().mapToInt(i->i).toArray();    
        }
    }
}