import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        my_string = my_string.toLowerCase();
        
        String[] strs = my_string.split("");
        
        Arrays.sort(strs);
        
        String answer = "";
        
        for(int i=0; i<strs.length; i++) {
            answer += strs[i];
        }
        
        return answer;
    }
}