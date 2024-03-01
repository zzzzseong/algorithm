class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i=myString.length(); i>=0; i--) {
            
            String ss = "";
            if(i-pat.length() >= 0) {
                ss = myString.substring(i-pat.length(), i);
            }
            
            if(pat.equals(ss)) {
                answer = myString.substring(0, i);
                break;
            }
        }
        
        return answer;
    }
}