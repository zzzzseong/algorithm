import java.util.*;

class Solution {
    public void init(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
    }
    
    public int solution(int[] A, int[] B) {
        
        init(A, B);
        
        int aIdx = 0, bIdx = 0;
        
        int len = A.length;
        
        int answer = 0;
        while(bIdx < len) {
            if(B[bIdx] <= A[aIdx]) {
                bIdx++;
                continue;
            }
            
            answer++;
            aIdx++;
            bIdx++;
        }
        
        
        return answer;
    }
}

//A: 2233
//B: 1133

//자연수는 1부터 10억까지
//몇 번 이기는지 return