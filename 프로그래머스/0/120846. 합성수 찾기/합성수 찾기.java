class Solution {
    public int solution(int n) {
        
        int answer = 0;
        for(int i=4; i<=n; i++) {
            
            double sqrt = Math.sqrt(i);
            
            int j;
            int cnt = 0;
            for(j=1; j<sqrt; j++) {
                if(i%j != 0) continue;
                
                cnt += 2;
            }
            
            if(j == sqrt) cnt++;
            
            if(cnt >= 3) answer++;
        }
        
        
        return answer;
    }
}