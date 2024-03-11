class Solution {
    public int[][] solution(int n) {
        
        int[][] map = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        
        // 우, 하, 좌, 상
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int count = n*n;
        
        int x = 0;
        int y = 0;
        int d = 0;
        
        map[0][0] = 1;
        vis[0][0] = true;
        
        while(count > 1) {            
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            
            if(nx >= n || nx < 0 || ny >= n || ny < 0 || vis[nx][ny]) {
                if(++d > 3) d = 0;
                continue;
            }
            
            map[nx][ny] = map[x][y]+1;
            vis[nx][ny] = true;
            
            x = nx;
            y = ny;
            
            count--;
        }
        
        return map;
    }
}