class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return arr;
        
        int m = 1;
        for(int i=0; i<10; i++) {
            m *= 2;
            
            if(arr.length <= m) {
                int[] answer = new int[m];
                
                for(int j=0; j<arr.length; j++) {
                    answer[j] = arr[j];
                }
                
                //arr.length와 m이 같은 경우 loop 실행 x
                for(int j=arr.length; j<m; j++) {
                    answer[j] = 0;
                }
                
                return answer;
            }
        }
        
        return null;
    }
}