import java.util.*;

class Solution {
    public void init(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
    }
    
    public int solution(int[] A, int[] B) {
        init(A, B);
        
        int aIdx = 0;
        int answer = 0;
        
        for(int bIdx=0; bIdx<B.length; bIdx++) {
            if(B[bIdx] > A[aIdx]){
                aIdx++;
                answer++;
            }
        }
        
        return answer;
    }
}