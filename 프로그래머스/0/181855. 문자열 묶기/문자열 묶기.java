class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[strArr.length+1];
        
        for(int i=0; i<strArr.length; i++) {
            count[strArr[i].length()]++;
        }
        
        int answer = 0;
        for(int c : count) {
            answer = Math.max(answer, c);
        }
        
        return answer;
    }
}