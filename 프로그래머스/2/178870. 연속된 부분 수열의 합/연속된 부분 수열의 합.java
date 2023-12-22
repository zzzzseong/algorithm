class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = sequence.length;
        
        int sum = 0;
        int j = 0;
        for(int i=0; i<sequence.length; i++) {
            while(sum < k && j < sequence.length) sum += sequence[j++];
            
            if(sum == k) {
                if((right-left) > j-i) {
                    left = i;
                    right = j;
                }
            }
            
            sum -= sequence[i];
        }
        
        int[] answer = {left, right-1};
        return answer;
    }
}