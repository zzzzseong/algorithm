class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    private int sx, sy;
    private int N, M;
    
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        
        LOOP1: 
        for(int i=0; i<N; i++) {
            String line = park[i];
            
            for(int j=0; j<M; j++) {
                if(line.charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                    break LOOP1;
                }
            }
        }
        
        return go(park, routes, sx, sy);
    }
    
    public int[] go(String[] park, String[] routes, int x, int y) {
        for(int i=0; i<routes.length; i++) {
            String[] split = routes[i].split(" ");
            int loop = Integer.parseInt(split[1]);
            int idx = getIdx(split[0].charAt(0));
            
            int nx = x;
            int ny = y;
            for(int j=0; j<loop; j++) {
                nx += dx[idx];
                ny +=dy[idx];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;;
                if(park[nx].charAt(ny) == 'X') break;
            
                if(j == loop-1) {
                    x = nx;
                    y = ny;    
                }
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
    
    public int getIdx(char dir) {
        if(dir == 'N') return 0;
        else if(dir == 'S') return 1;
        else if(dir == 'W') return 2;
        else return 3;   
    }
}