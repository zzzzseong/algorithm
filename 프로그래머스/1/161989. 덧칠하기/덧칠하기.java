class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int curr = 0;
                
        for(int sec : section) {
            if(sec > curr) {
                curr = sec + (m-1);
                answer++;
            }
        }
        
        return answer;
    }
}