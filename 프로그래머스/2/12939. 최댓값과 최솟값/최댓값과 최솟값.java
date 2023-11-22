import java.util.*;

class Solution {
    public String solution(String s) {                
        int[] sequence = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<sequence.length; i++) {
            max = Math.max(max, sequence[i]);
            min = Math.min(min, sequence[i]);
        }
        
        return min + " " + max;
    }
}