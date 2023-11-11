import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i=1; i<10; i++) {
            answer += i;
        }
        
        return answer - Arrays.stream(numbers).sum();
    }
}