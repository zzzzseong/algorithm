import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        
        String answer = "";
        
        int idx=0;
        for(int i=0; i<my_string.length(); i++) {
            if(idx < indices.length && i == indices[idx]) {
                idx++;
                continue;
            }
            
            answer += my_string.charAt(i);
        }
        
        
        return answer;
    }
}