class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]%2 == 0) {
                answer[i] = numbers[i]+1;
            } else {
                answer[i] = odd(numbers[i]);
            }
        }
            
        return answer;
    }
    
    public long odd(long num) {
        int idx = 0;
        long mask = 0;
        while(true) {
            long pow = 1L << idx;
            
            if((num & pow) >= 1) {
                idx++;
            } else {
                mask = pow + (1L << (idx-1));
                break;
            }
        }
        
        return (num ^ mask);
    }
}