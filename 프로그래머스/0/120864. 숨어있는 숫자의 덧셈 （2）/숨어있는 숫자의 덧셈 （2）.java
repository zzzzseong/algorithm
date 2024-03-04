class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if(isNumber(c)) {
                int sIdx = i;
                int eIdx = i;
                
                while(i != my_string.length()-1 && isNumber(my_string.charAt(++i))) {
                    eIdx = i;
                }
                      
                answer += Integer.parseInt(my_string.substring(sIdx, eIdx+1));
            }
        }
        
        return answer;
    }
    
    public boolean isNumber(char c) {
        if(c >= '0' && c <= '9') return true;
        else return false;
    }
}