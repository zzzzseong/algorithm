class Solution {
    public int solution(int n) {
        int answer;
        for(answer=1; answer<= n; answer++) {
            if(n % answer == 1) break;;
        }
        return answer;
    }
}