class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        int answer = 0;
        
        //1. sides 중 max값이 가장 긴 선분인 경우
        for(int i=max-1; i>=0; i--) {
            if(max < min+i) answer++;
            else break;
        }
        
        //2. 새로운 값이 가장 긴 선분인 경우        
        for(int i=max; i<max+min; i++) {
            answer++;
        }
        
        return answer;
    }
}