class Solution {
    private int c0 = 0;
    private int c1 = 0;
    private int count = 0;
    
    public void init(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] == 0) c0++;
                else c1++;
            }
        }
    }
    
    public int[] solution(int[][] arr) {
        init(arr);
        
        compression(arr, 0, arr.length, 0, arr.length);
        
        int[] answer = {c0, c1};
        return answer;
    }
    
    public void compression(int[][] arr, int sx, int ex, int sy, int ey) {        
        if(ex-sx == 1 && ey-sy == 1) return;
        
        //범위 내 모든 수가 동일하다면
        if(quad(arr, sx, ex, sy, ey)) {
            int minus = ((ex-sx)*(ey-sy)-1);
            if(arr[sx][sy] == 0) c0 -= minus;
            if(arr[sx][sy] == 1) c1 -= minus;
            
            return;
        }
            
        int mx = (sx + ex)/2;
        int my = (sy + ey)/2;
        
        compression(arr, sx, mx, sy, my);
        compression(arr, mx, ex, sy, my);
        compression(arr, sx, mx, my, ey);
        compression(arr, mx, ex, my, ey);        
    }
    
    public boolean quad(int[][] arr, int sx, int ex, int sy, int ey) {
        int num = arr[sx][sy]; //이 수를 기준으로 압축
        for(int i=sx; i<ex; i++) {
            for(int j=sy; j<ey; j++) {
                if(arr[i][j] != num) return false; 
            }
        }
        
        return true;
    }
}