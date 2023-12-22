class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 1;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i%3 == 0) {  
                    x++;
                }
                if(i%3 == 1) {
                    y++;
                }
                if(i%3 == 2) {
                    x--;
                    y--;
                }
                
                map[x][y] = num++;
            }
        }
        
        int idx = 0;
        int[] answer = new int[n*(n+1)/2];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<=i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}