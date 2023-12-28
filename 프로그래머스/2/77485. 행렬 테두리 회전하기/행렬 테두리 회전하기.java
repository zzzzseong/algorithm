class Solution {
    private int[][] map;
    
    public void init(int rows, int columns) {
        map = new int[rows][columns];
        
        int num = 1;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                map[i][j] = num++;
            }
        }
        
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns);
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query) {
        int sx = query[0]-1;
        int sy = query[1]-1;
        int ex = query[2]-1;
        int ey = query[3]-1;
                
        int tmp = map[ex][ey];
        int min = tmp;
        
        //오른쪽 아래 밀기
        for(int i = ex-1; i>=sx; i--) {
            map[i+1][ey] = map[i][ey];
            min = Math.min(min, map[i][ey]);
        }
        
        //위 오른쪽 밀기
        for(int i = ey-1; i>=sy; i--) {
            map[sx][i+1] = map[sx][i];
            min = Math.min(min, map[sx][i]);
        }
        
        //왼쪽 위 밀기
        for(int i = sx+1; i<=ex; i++) {
            map[i-1][sy] = map[i][sy];
            min = Math.min(min, map[i][sy]);
        }
        
        //아래 왼쪽 밀기
        for(int i = sy+1; i<ey; i++) {
            map[ex][i-1] = map[ex][i];
            min = Math.min(min, map[ex][i]);
        }
        
        map[ex][ey-1] = tmp;
        
        return min;
    }
}