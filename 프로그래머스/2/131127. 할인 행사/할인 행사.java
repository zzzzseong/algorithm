import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();

    public void init(String[] wants) {
        for(String want : wants) {
            map.put(want, 0);
        }
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        init(want);
        int answer = 0;
    
        for(int i=0; i<10; i++) {
            if(map.get(discount[i]) != null) {
                map.put(discount[i], map.get(discount[i])+1);   
            }
        }
        if(scan(want, number)) answer++;
        
        for(int i=10; i<discount.length; i++) {
            if(map.get(discount[i-10]) != null) map.put(discount[i-10], map.get(discount[i-10])-1);
            if(map.get(discount[i]) != null) map.put(discount[i], map.get(discount[i])+1);
            if(scan(want, number)) answer++;
        }
        
        return answer;
    }
    
    public boolean scan(String[] want, int[] number) {
        for(int i=0; i<want.length; i++) {
            if(map.get(want[i]) < number[i]) return false;
        }
        return true;
    }
}