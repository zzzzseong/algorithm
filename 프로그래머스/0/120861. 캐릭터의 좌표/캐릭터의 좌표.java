class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        String[] dstr = {"up", "down", "left", "right"};
        
        for(int i=0; i<keyinput.length; i++) {
            
            int nx = x;
            int ny = y;
            
            for(int j=0; j<dstr.length; j++) {
                if(dstr[j].equals(keyinput[i])) {
                    nx += dir[j][0];
                    ny += dir[j][1];
                }
            }
            
            if(nx > board[0]/2 || nx < -board[0]/2 || ny > board[1]/2 || ny < -board[1]/2) continue;
            
            x = nx;
            y = ny;
        }
        
        return new int[]{x, y};
    }
}