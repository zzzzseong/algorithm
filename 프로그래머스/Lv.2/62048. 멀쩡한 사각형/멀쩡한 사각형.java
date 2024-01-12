class Solution {
    public long solution(int w, int h) {
                    
        int curX = 1, curY = 1;
        
        long answer = 0;
        while(curX <= w) {
            answer++;
                        
            double y = fx(w, h, curX);
            
            if(y < curY) {
                curX++;
            } else if(y == curY) {
                curX++;
                curY++;
            } else {
                curY++;
            }
        }
                
        return (long)w*h-answer;
    }
    
    public double fx(int w, int h, double x) {
        return (double)h*x/w;
    }
}