import java.util.*;

class Solution {
    //map 크기
    private int N, M;
    
    //시작 좌표, 레버 좌표, 출구 좌표
    private int sx, sy, lx, ly, ex, ey;
    
    //이동 변화값 배열
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    //노드 방문 기록 배열
    private boolean[][] vis;
    
    public void init(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
                if(maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        vis = new boolean[N][M];
    }
    
    public int solution(String[] maps) {
        init(maps);
        
        int[] s = {sx, sy};
        int[] l = {lx, ly};
        int[] e = {ex, ey};
        
        int stol = bfs(maps, s, l);
        if(stol == -1) return -1;
        
        //방문 기록 초기화
        for(boolean[] v : vis) {
            Arrays.fill(v, false);
        }
        
        int ltoe = bfs(maps, l, e);
        if(ltoe == -1) return -1;
        
        return stol + ltoe;
    }
    
    public int bfs(String[] maps, int[] start, int[] end) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        
        int[][][] hist = new int[N][M][2];
        
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            if(cur[0] == end[0] && cur[1] == end[1]) {
                int curX = cur[0];
                int curY = cur[1];
                
                int count = 0;
                while(curX != start[0] || curY != start[1]) {                    
                    int[] h = hist[curX][curY];
                    
                    curX = h[0];
                    curY = h[1];
                    
                    count++;
                }
                
                return count;
            }
            
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                
                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                if(vis[nx][ny]) continue;
                
                vis[nx][ny] = true;
                hist[nx][ny][0] = cur[0];
                hist[nx][ny][1] = cur[1];
                
                int[] next = {nx, ny};
                dq.offer(next);
            }
        }
        
        return -1;
    }
}