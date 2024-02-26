import java.util.*;

class Solution {
    
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private boolean[][] vis;
    private int[][][] hist;
    
    private int N, M;
    private int sx, sy;
    
    public void init(String[] board) {
        N = board.length;
        M = board[0].length();
        
        vis = new boolean[N][M];
        hist = new int[N][M][2];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if('R' == board[i].charAt(j)) {
                    sx = i;
                    sy = j;
                }
            }
        }
    }
    
    public int solution(String[] board) {
        init(board);
        
        int[] start = {sx, sy};
        return bfs(board, start);
    }
    
    public int bfs(String[] board, int[] start) {
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        
        //시작 지점 방문 처리
        vis[start[0]][start[1]] = true;
        
        while(!dq.isEmpty()) {
            int[] node = dq.remove();
            
            for(int i=0; i<dir.length; i++) {
                int[] nextNode = getNextPos(board, node[0], node[1], dir[i]);
                
                if(vis[nextNode[0]][nextNode[1]]) continue;
                
                hist[nextNode[0]][nextNode[1]][0] = node[0];
                hist[nextNode[0]][nextNode[1]][1] = node[1];
                
                if('G' == board[nextNode[0]].charAt(nextNode[1])) {
                    
                    int ax = nextNode[0];
                    int ay = nextNode[1];
                    
                    int cnt = 0;
                    while(true) {
                        int nax = hist[ax][ay][0];
                        int nay = hist[ax][ay][1];
                        
                        ax = nax;
                        ay = nay;
                        
                        cnt++;
                        
                        if(ax == sx && ay == sy) break;
                    }
                    
                    return cnt;
                }
                                
                vis[nextNode[0]][nextNode[1]] = true;
                dq.add(nextNode);
            }
        }
        
        return -1;
    }
    
    public int[] getNextPos(String[] board, int x, int y, int[] dir) {
        
        while(true) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if((nx >= N || nx < 0 || ny >= M || ny < 0) || 'D' == board[nx].charAt(ny))  {
                int[] ret = {x, y};
                return ret;
            }
            
            x = nx;
            y = ny;
        }
    }
}