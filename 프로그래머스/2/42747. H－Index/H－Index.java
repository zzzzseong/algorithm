import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int i;
        for (i = citations.length-1; i >= 0; i--) {
            if(citations[i] < citations.length - i) break;
        }
        
        return citations.length - i - 1;
    }
}