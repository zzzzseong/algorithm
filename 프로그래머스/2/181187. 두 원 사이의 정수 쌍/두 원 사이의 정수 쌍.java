

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x, y축에 포함된 정점 갯수 더하기
        answer += (r2-r1+1)*4;
        
        long sum = 0;
        int idx = 0;
        
        for(idx=1; idx<=r1; idx++) {
            double y2 = Math.sqrt((long)r2*r2-(long)idx*idx);
            double y1 = Math.sqrt((long)r1*r1-(long)idx*idx);
            
            // System.out.printf("y2 = %f, y1 = %f\n", y2, y1);
            
            sum += (int)y2-(int)y1;
            
            if(y1 != 0.0 && y1%1.0 == 0) sum++;
        }
        
        for(int i=idx; i<=r2; i++) {            
            int y2 = (int) Math.sqrt((long)r2*r2- (long)i*i);
            sum += y2;
        }
        
        answer += sum*4;
        
        return answer;
    }
}