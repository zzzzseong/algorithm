class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            if(getNumberOfDivisor(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    public boolean getNumberOfDivisor(int num) {
        double sqrt = Math.sqrt(num);
        
        int divisor = 0;
        for(int i=1; i<=sqrt; i++) {
            if(i*i == num) {
                divisor++;
                continue;
            }
            if(num % i == 0) {
                divisor += 2;
            }
        }
        
        if(divisor % 2 == 0) return true;
        else return false;
    }
}