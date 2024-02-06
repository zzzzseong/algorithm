class Solution {
    public String solution(String code) {
        
        int mode = 0;
        
        String answer = "";
        for(int i=0; i<code.length(); i++) {
            if(mode == 0) {
                if(code.charAt(i) != '1') {
                    if(i%2 == 0) {
                        answer += code.charAt(i);
                    }
                } else {
                    mode = 1;
                }
            } else {
                if(code.charAt(i) != '1') {
                    if(i%2 != 0) {
                        answer += code.charAt(i);
                    }
                } else {
                    mode = 0;
                }
            }
        }
        
        if("".equals(answer)) {
            return "EMPTY";
        } else {
            return answer;    
        }
    }
}