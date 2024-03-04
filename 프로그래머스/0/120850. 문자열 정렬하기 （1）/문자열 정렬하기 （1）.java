import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if('0' <= c && '9' >= c) list.add(Integer.parseInt(String.valueOf(c)));
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}