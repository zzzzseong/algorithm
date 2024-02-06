class Solution {
    public String solution(int[] numLog) {
        
        String answer = "";
        for(int i=1; i<numLog.length; i++) {
            int dir = numLog[i]-numLog[i-1];
            
            if(dir == 1) {
                answer += "w";
            }
            if(dir == -1) {
                answer += "s";
            }
            if(dir == 10) {
                answer += "d";
            }
            if(dir == -10) {
                answer += "a";
            }
        }
        
        return answer;
    }
}