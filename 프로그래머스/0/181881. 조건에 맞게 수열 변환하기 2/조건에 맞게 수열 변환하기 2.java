class Solution {
    public int solution(int[] arr) {
        
        int answer = 0;
        while(true) {
            int[] narr = new int[arr.length];
            
            for(int i=0; i<arr.length; i++) {
                
                if(arr[i] >= 50 && arr[i]%2==0)  {
                    narr[i] = arr[i]/2;
                }
                if(arr[i] < 50 && arr[i]%2 != 0) {
                    narr[i] = arr[i]*2+1;
                }
            }
            
            boolean stop = true;
            for(int i=0; i<arr.length; i++) {
                if(arr[i] != narr[i]) {
                    stop = false;
                    break;
                }
            }
            
            if(stop) break;
            
            arr = narr;
            answer++;
        }
        
        return answer-1;
    }
}