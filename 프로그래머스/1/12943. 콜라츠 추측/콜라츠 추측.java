class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while(num != 1) {
            if(answer > 500) {
                answer = -1;
                break;
            }
            answer++;
            
            if(num % 2 == 1) {
                num *= 3;
                num += 1;
            } else {
                num /= 2;   
            }
        }
        
        return answer;
    }
}