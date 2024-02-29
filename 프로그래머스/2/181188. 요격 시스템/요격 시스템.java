import java.util.*;

class Solution {    
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (o1, o2) -> {
           return o1[1]-o2[1] ;
        });
        

        int answer = 0;
        int x = 0;
        for(int i=0; i<targets.length; i++) {
            if(x <= targets[i][0]) {
                x = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}