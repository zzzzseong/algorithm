class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        int count = 0;
        while(chicken > 0) {
            chicken--;
            count++;
            
            if(count == 10) {
                chicken++;
                answer++;
                count = 0;
            }
        }
        
        return answer;
    }
}