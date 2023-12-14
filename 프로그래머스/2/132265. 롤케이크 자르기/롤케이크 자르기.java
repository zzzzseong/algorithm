import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<Integer, Integer> left = new HashMap<>();
    private Map<Integer, Integer> right = new HashMap<>();
    
    public int solution(int[] topping) {        
        for(int i=0; i<topping.length; i++) {
            if(right.get(topping[i]) == null) right.put(topping[i], 0);
            right.put(topping[i], right.get(topping[i])+1);
        }
        
        int lSize = 0;
        int rSize = right.size();
        
        int answer = 0;
        for(int i=0; i<topping.length-1; i++) {
            //left는 토핑의 갯수를 count할 필요 없음
            if(left.get(topping[i]) == null) {
                left.put(topping[i], 0);
                lSize++;
            }
            
            //right.get(topping[i])는 null일 수 없음
            int count = right.get(topping[i]);
            
            right.put(topping[i], count-1);
            if((count-1) == 0) {
                rSize--;   
            }
            
            if(lSize == rSize) answer++;
        }
        
        return answer;
    }
}