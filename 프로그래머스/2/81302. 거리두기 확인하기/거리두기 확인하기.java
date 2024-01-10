import java.util.*;

class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<places.length; i++) {
            if(search(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    public boolean search(String[] place) {
        for(int j=0; j<place.length; j++) {
            String row = place[j];
            
            for(int k=0; k<row.length(); k++) {
                
                if(row.charAt(k) == 'P') {
                    
                    if(!bfs(place, j, k)) {
                        return false;
                    }
                }

            }
        }
        
        return true;
    }
    
    public boolean bfs(String[] place, int sx, int sy) {
        //|r1 - r2| + |c1 - c2|
        boolean[][] vis = new boolean[5][5];
        
        Deque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(sx, sy));
        
        while(!q.isEmpty()) {
            Node node = q.removeFirst();
            vis[node.getX()][node.getY()] = true;
            
            
            for(int dir=0; dir<4; dir++) {
                int nx = node.getX() + dx[dir];
                int ny = node.getY() + dy[dir];
                
                if(nx >= 5 || nx < 0 || ny >= 5 || ny < 0) continue;
                if(place[nx].charAt(ny) == 'X') continue;
                if(vis[nx][ny]) continue;
                if(Math.abs(sx-nx) + Math.abs(sy-ny) > 2) continue;
                
                if(place[nx].charAt(ny) == 'P') return false;
                
                q.addLast(new Node(nx, ny));
            }
        }
        
        return true;
    }
}

class Node {
    private int x;
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}