class Solution {
    public String solution(String s) {        
        int idx = s.length()/2;
        if(s.length() % 2 == 1) {
            return s.substring(idx, idx+1);
        } else {
            return s.substring(idx-1, idx+1);
        }
    }
}