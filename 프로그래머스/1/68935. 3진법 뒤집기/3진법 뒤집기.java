class Solution {
    public int solution(int n) {
        String answer = "";
        
        String[] num = Integer.toString(n, 3).split("");
        for(int i=num.length-1; i>=0; i--) {
            answer += num[i];
        }
        
        return Integer.parseInt(answer, 3);
    }
}