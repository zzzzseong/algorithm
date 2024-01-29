import java.util.*;

class Solution {
    public int solution(int[][] land) {
        
        int[][] answer = new int[land.length][4];
        
        answer[0][0] = land[0][0];
        answer[0][1] = land[0][1];
        answer[0][2] = land[0][2];
        answer[0][3] = land[0][3];
        
        for(int i=0; i<land.length-1; i++) {
            for(int j=0; j<4; j++) {
                for(int k=0; k<4; k++) {
                    if(j==k) continue;
                    
                    answer[i+1][k] = Math.max(answer[i+1][k], answer[i][j] + land[i+1][k]);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<4; i++) {
            max = Math.max(max, answer[answer.length-1][i]);
        }
        
        return max;
    }
}