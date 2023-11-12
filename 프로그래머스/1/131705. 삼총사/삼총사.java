class Solution {
    private int answer = 0;
    
    public int solution(int[] number) {        
        boolean[] vis = new boolean[number.length];
        combination(number, vis, 0, 3, 0);
        
        return answer;
    }
    
    public void combination(int[] number, boolean[] vis, int sIdx, int r, int sum) {
        if(r == 0) {
            if(sum == 0) answer++;
            return;
        }
        
        for(int i=sIdx; i<number.length; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            combination(number, vis, i+1, r-1, sum + number[i]);
            vis[i] = false;
        }
    }
}