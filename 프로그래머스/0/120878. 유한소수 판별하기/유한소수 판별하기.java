import java.util.*;

class Solution {
    public int solution(int a, int b) {
        
        List<Integer> list = new ArrayList<>();
        
        int div = 2;
        
        while(b >= div) {            
            if(b%div == 0) {
                list.add(div);
                b /= div;
            } else {
                div++;
            }
        }
                
        for(int i=0; i<list.size(); i++) {
            int num = list.get(i);
            
            if(num != 2 && num != 5) {
                if(a%num != 0) return 2;
                else a /= num;
            }
        }
        
        return 1;
    }
}