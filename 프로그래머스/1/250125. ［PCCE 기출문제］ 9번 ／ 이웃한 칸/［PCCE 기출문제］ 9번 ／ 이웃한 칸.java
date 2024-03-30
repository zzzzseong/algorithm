class Solution {
    
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[][] board, int h, int w) {
        
        int len = board.length;
        
        int answer = 0;
        for(int i=0; i<dir.length; i++) {
            int nx = h + dir[i][0];
            int ny = w + dir[i][1];
            
            if(nx >= len || nx < 0 || ny >= len || ny < 0) continue;
            
            if(board[nx][ny].equals(board[h][w])) answer++;
        }
        
        return answer;
    }
}