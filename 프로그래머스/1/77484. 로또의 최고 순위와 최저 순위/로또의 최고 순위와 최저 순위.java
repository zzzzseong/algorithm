class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) zeroCount++;
        }
        
        int hitCount = 0;
        for(int i=0; i<win_nums.length; i++) {
            for(int j=0; j<lottos.length; j++) {
                if(lottos[j] == win_nums[i]) {
                    hitCount++;
                    break;
                }
            }
        }
        
        int[] answer = {hitCount+zeroCount == 0 ? 6 : 7-(hitCount+zeroCount), hitCount == 0 ? 6 : 7-hitCount};
        return answer;
    }
}