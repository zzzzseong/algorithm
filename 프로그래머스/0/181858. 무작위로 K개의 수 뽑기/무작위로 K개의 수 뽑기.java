class Solution {
    public int[] solution(int[] arr, int k) {
        boolean[] vis = new boolean[100_001];
        
        int[] answer = new int[k];
        
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(!vis[arr[i]]) {
                answer[count++] = arr[i];
                vis[arr[i]] = true;
                
                if(count == k) break;
            }
        }
        
        for(int i=count; i<answer.length; i++) {
            answer[i] = -1;
        }
        
        return answer;
    }
}