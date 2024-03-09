class Solution {
    
    private int answer = 0;
    
    public int solution(int n, long l, long r) {
        
        long m = (long)Math.pow(5, n-1);
        
        return (int)(divide(n, r, m) - divide(n, l-1, m));
    }
    
    public long divide(int n, long pos, long m) {
        
        if(pos == m*5) return (long) Math.pow(4, n);
        // if(n == 1) return pos >= 3 ? pos-1 : pos;
        
        if(n == 1) {
            int sum = 0;
            
            for(int i=1; i<=pos; i++) {
                if(i == 3) continue;
                
                sum++;
            }
            
            return sum;
        }
        
        
        long ret = 0;
        for(int i=1; i<=5; i++) {
            if(i == 3) continue;
            
            if(pos > m*i) ret += divide(n-1, m, m/5);
            else {
                ret += divide(n-1, pos-m*(i-1), m/5);
                break;
            }
        }
        
        return ret;
    }
}