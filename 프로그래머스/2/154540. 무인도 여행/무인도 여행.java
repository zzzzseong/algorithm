import java.util.*;

class Solution {
    private boolean[][] vis;
    private int[][] map;
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    private List<Integer> list = new ArrayList<>();
    
    public void init(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        vis = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            String[] line = maps[i].split("");
            
            for(int j=0; j<line.length; j++) {
                if("X".equals(line[j])) map[i][j] = -1;
                else map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
    
    public int[] solution(String[] maps) {
        init(maps);
        
        int idx = 0;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(vis[i][j]) continue;
                if(map[i][j] == -1) continue;
         
                list.add(0);
                spread(i, j, idx++);
            }
        }
        
        if(list.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void spread(int x, int y, int idx) {
        vis[x][y] = true;
        list.set(idx, list.get(idx) + map[x][y]);
        
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= map.length || nx < 0 || ny >= map[0].length || ny < 0) continue;
            if(vis[nx][ny]) continue;
            if(map[nx][ny] == -1) continue;
            
            vis[nx][ny] = true;            
            spread(nx, ny, idx);
        }
    }
}