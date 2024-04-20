import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s) return new int[]{-1};
        
        Arrays.fill(answer, s/n);        
        int mod = s%n;
        
        int idx = n-1;
        while(mod-- > 0) {
            if(idx < 0) idx = n-1;
            answer[idx--]++;
        }
                
        return answer;
    }
}