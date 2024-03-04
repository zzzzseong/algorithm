class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        
        int min = Math.abs(answer-n);
        
        for(int i=1; i<array.length; i++) {
            int d = Math.abs(array[i] - n);
            
            if(d < min) {
                min = d;
                answer = array[i];
            }
            
            if(d == min) answer = Math.min(answer, array[i]);
        }
        
        return answer;
    }
}