import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int len = numbers.length;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[len-1]);
        answer[len-1] = -1;
        
        for(int i=len-2; i>=0; i--) {
            while(!stack.isEmpty()) {
                if(stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop(); 
                }
            }
            
            if(stack.isEmpty()) {
                answer[i] = -1;
            }
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}