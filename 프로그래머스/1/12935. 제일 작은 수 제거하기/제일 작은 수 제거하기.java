import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int[] answer = new int[arr.length-1];
        int idx = 0;
        for(int num : arr) {
            if(min == num) continue;
            answer[idx++] = num;
        }
        
        return answer;
    }
}