import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private int[] circle;
    private int[][] dp;
    
    public void init(int[] elements) {
        int N = elements.length;
        circle = new int[N*2];
        for(int i=0; i<N; i++) {
            circle[i] = elements[i];
            circle[elements.length + i] = elements[i];
        }
        
        dp = new int[N][N+1];
        for(int i=0; i<N; i++) {
            dp[i][0] = elements[i];
            set.add(dp[i][0]);
        }
    }
    
    public int solution(int[] elements) {
        init(elements);
        
        for(int i=1; i<elements.length; i++) {
            for(int j=0; j<elements.length; j++) {                
                dp[j][i] = dp[j][i-1] + circle[i+j];
                set.add(dp[j][i]);
            }
        }
        
        return set.size();
    }
}