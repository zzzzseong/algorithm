class Solution {
    public int[] solution(int[] arr) {
        
        int sIdx = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                sIdx = i;
                break;
            }
        }
        
        int eIdx = arr.length-1;
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] == 2) {
                eIdx = i;
                break;
            }
        }
        
        
        
        int[] answer = new int[eIdx-sIdx+1];
        int idx = 0;
        for(int i=sIdx; i<=eIdx; i++) {
            answer[idx++] = arr[i];
        }
        
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == 2) return answer;
        }
        
        int[] ret = {-1};
        return ret;
    }
}