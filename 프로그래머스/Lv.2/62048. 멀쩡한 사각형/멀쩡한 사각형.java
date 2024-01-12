class Solution {
    public long solution(int w, int h) {
                    
        double curX = 1, curY = 1;
        
        long answer = 0;
        while(curX <= w) {
            answer++;
                        
            double y = fx((double)w, (double)h, curX);
            // System.out.println("x = " + curX + " y = " + curY + " d = " + y);
            
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
    
    public double fx(double w, double h, double x) {
        return h*x/w;
    }
}