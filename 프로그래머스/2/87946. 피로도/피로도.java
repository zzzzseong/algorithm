class Solution {
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] vis = new boolean[dungeons.length];
        
        dfs(dungeons, vis, k, 0, 0);
        return answer;
    }
    
    public void dfs(int[][] dungeons, boolean[] vis, int k, int count, int depth) {
        if(depth == dungeons.length) {
            answer = Math.max(answer, count);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            if(dungeons[i][0] > k) dfs(dungeons, vis, k, count, depth+1);
            else dfs(dungeons, vis, k-dungeons[i][1], count+1, depth+1);
            vis[i] = false;
        }
    }
}