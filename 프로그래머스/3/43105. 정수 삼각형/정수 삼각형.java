class Solution {
    
    //prefix sum array
    private int[][] dp;
    
    public void init(int[][] triangle) {
        
        dp = new int[triangle.length][];
        
        for(int i=0; i<triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        dp[0][0] = triangle[0][0];
    }
    
    public int solution(int[][] triangle) {
        init(triangle);
        
        for(int i=1; i<triangle.length; i++) {
            
            //왼쪽 외곽 처리
            dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + triangle[i][0]);
            
            for(int j=1; j<triangle[i].length-1; j++) {
                
                // dp[i][j]와 dp[i-1][j] + triangle[i][j], dp[i-1][j-1] + triangle[i][j] 중 max값 dp에 메모이제이션
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + triangle[i][j]);
                
            }
            
            //오른쪽 외곽 처리
            int len = dp[i].length-1;
            dp[i][len] = Math.max(dp[i][len], dp[i-1][len-1] + triangle[i][len]);
        }
        
        int l = dp.length-1;
        int answer = 0;
        for(int i=0; i<dp[l].length; i++) {
            answer = Math.max(answer, dp[l][i]);
        }
        
        return answer;
    }
}