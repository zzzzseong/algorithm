class Solution {
    
    private int[] vis;
    
    private int answer = 0;
    
    public int solution(int n) {
        vis = new int[n];
        
        nQueen(n, 0);
        
        return answer;
    }
    
    public void nQueen(int n, int y) {
        if(y == n) {
            answer++;
            return;
        }
        
        for(int x=0; x<n; x++) {
            vis[y] = x;
            
            if(marking(y)) nQueen(n, y+1);
        }
    }
    
    public boolean marking(int y) {
     
        for(int i=0; i<y; i++) {
            
            //가로 직선방향 공격
            if(vis[i] == vis[y]) return false;
            
            //대각선방향 공격
            if(Math.abs(i-y) == Math.abs(vis[i]-vis[y])) return false;
        }
        
        return true;
    }
}