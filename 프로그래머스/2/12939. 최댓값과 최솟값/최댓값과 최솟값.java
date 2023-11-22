import java.util.*;

class Solution {
    public String solution(String s) {                
        int[] sequence = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(sequence).min().getAsInt() + " " + Arrays.stream(sequence).max().getAsInt();
            
    }
}