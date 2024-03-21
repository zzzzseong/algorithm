import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        
        int answer = 0;
        for(int i=0; i<d.length; i++) {
            if(budget - d[i] >= 0) {
                answer++;
                budget -= d[i];
            } else {
                break;
            }
        }
        
        return answer;
    }
}