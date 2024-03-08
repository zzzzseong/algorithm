class Solution {
    public int solution(int[] numbers, int k) {
        
        int curIdx = 0;
        
        while(k > 1) {
            curIdx += 2;
            
            k--;
            
            if(curIdx == numbers.length) {
                curIdx = 0;
                continue;
            }
            if(curIdx == numbers.length+1) {
                curIdx = 1;
            }
        }
        
        
        return curIdx+1;
    }
}