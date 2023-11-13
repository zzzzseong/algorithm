class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int p = getNumOfDivisor(i); //p -> 약수의 갯수
            
            if(p > limit) answer += power;
            else answer += p;
        }
        
        return answer;
    }
    
    public int getNumOfDivisor(int num) {
        double sqrt = Math.sqrt(num);
        
        int sum = 0;
        for(int i=1; i<=sqrt; i++) {
            if(i == sqrt) {
                sum += 1;
                break;
            }
            if(num % i == 0) sum += 2;
        }

        return sum;
    }
}