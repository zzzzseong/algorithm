class Solution {
    
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        boolean[][] area = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) markDangerArea(i, j, n, area);
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!area[i][j]) answer++;
            }
        }
        
        return answer;
    }
    
    public void markDangerArea(int x, int y, int n, boolean[][] area) {
        area[x][y] = true;
        
        for(int i=0; i<dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            if(nx >= n || ny >= n || nx < 0 || ny < 0) continue;
            
            area[nx][ny] = true;
        }
    }
}