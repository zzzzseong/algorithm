import java.util.*;

class Solution {
    
    private List<Integer> seq = new ArrayList<>();
    private double[] dp;
    
    public double[] solution(int k, int[][] ranges) {
        makeSeq(k);
        
        dp = new double[seq.size()];
                
        int n = seq.size()-1;
        
        double[] answer = new double[ranges.length];
        
        for(int i=0; i<ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = ranges[i][1];
            
            if(x2 <= 0) x2 = n+x2;
            
            answer[i] = getSize(x1, x2);
        }
        
        return answer;
    }
    
    public double getSize(int x1, int x2) {
        if(x1 > x2) return -1;
        
        if(x1 == x2) return 0.0;
        
        double sum = 0;
        while(x1 < x2) {
            
            if(dp[x1] != 0) {
                sum += dp[x1];
            } else {
                int num1 = seq.get(x1);
                int num2 = seq.get(x1+1);
                
                int max = Math.max(num1, num2);
                int min = Math.min(num1, num2);
                
                double size = (double) (max-min)/2;
                
                dp[x1] = size + min;
                sum += dp[x1];
            }
            
            x1++;
        }
        
        return sum;
    }
    
    public void makeSeq(int k) {
        seq.add(k);
        
        while(k != 1) {
            if(k%2 == 0) k /= 2;
            else k = k*3+1;
            
            seq.add(k);
        }
    }
    
    //1. k에 대한 우박수열을 구한 후 배열에 List에 x, y의 형식으로 넣는다
    //2. 각 ranges에 대해 정적분 값을 구한다
    //3. 각 범위 1-2, 2-3 단위로 쪼개서 구하는데 이미 구한 값은 dp에 메모이제이션한다
}