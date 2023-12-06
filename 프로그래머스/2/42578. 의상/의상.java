import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    
    public void init(String[][] clothes) {
        for(String[] cloth : clothes) {
            if(map.get(cloth[1]) == null) map.put(cloth[1], 0);
            map.put(cloth[1], map.get(cloth[1])+1);
        }
        
    }
    
    public int solution(String[][] clothes) {
        init(clothes);
        
        int answer = 1;
        for(int count : map.values()) {
            answer *= count+1;
        }
        
        return answer-1;
    }
}