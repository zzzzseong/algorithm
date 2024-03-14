class Solution {
    public String solution(String my_string) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        
        String answer = "";
        
        boolean tmp = false;
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if(c == ' ') {
                if(!tmp) {
                    answer += ' ';
                    tmp = true;    
                }
                
                continue;
            }
            
            if(c >= 'A' && c <= 'Z') {
                if(upper[c-'A']) continue;
                upper[c-'A'] = true;
            } else {
                if(lower[c-'a']) continue;
                lower[c-'a'] = true;
            }
            
            answer += c;
        }
        
        return answer;
    }
}