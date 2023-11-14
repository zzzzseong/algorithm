import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] x = new int[10];
        int[] y = new int[10];
        
        //3_000_000
        for(int i=0; i<X.length(); i++) {
            x[X.charAt(i)-'0']++;
        }
        
        //3_000_000
        for(int i=0; i<Y.length(); i++) {
            y[Y.charAt(i)-'0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(int i=9; i>=0; i--) {
            int min = Math.min(x[i], y[i]);
            if(i != 0 && min != 0) zero = false;
            
            for(int j=0; j<min; j++) {
                // answer += i;
                sb.append(i);
            }
        }
        
        if("".equals(sb.toString())) return "-1";
        if(zero) return "0";
        // return answer;
        return sb.toString();
    }
}