class Solution {
    public int solution(String my_string) {
        
        int answer = 0;
        
        String[] arr = my_string.split("");
        
        for(int i=0; i<my_string.length(); i++) {
            
            if(my_string.charAt(i) >= '1' && my_string.charAt(i) <= '9') {
                answer += Integer.parseInt(arr[i]);
            }
            
        }
        
        return answer;
    }
}