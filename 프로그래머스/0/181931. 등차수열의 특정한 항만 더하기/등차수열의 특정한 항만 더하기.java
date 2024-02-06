import java.util.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        
        int[] seq = new int[included.length];
        
        int num = a;
        for(int i=0; i<seq.length; i++) {
            seq[i] = num;
            num += d;
        }
                
        int answer = 0;
        for(int i=0; i<included.length; i++) {
            if(included[i]) {
                answer += seq[i];     
            }
        }
        
        return answer;
    }
}