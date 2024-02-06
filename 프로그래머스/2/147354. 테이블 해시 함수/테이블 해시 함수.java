import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (d1, d2) -> {
            if(d1[col-1] == d2[col-1]) {
                return d2[0]-d1[0];
            }
            
            return d1[col-1]-d2[col-1];
        });
                
        int answer = 0;
        for(int i=row_begin-1; i<row_end; i++) {            
            int num = getSI(data[i], i+1);
            answer = (answer ^ num);
        }
        
        return answer;
    }
    
    public int getSI(int[] data, int i) {        
        int sum = 0;
        for(int j=0; j<data.length; j++) {
            sum += data[j]%i;
        }
        
        return sum;
    }
}