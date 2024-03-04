class Solution {
    public int solution(int num, int k) {
        
        String str = String.valueOf(num);
        
        char ck = String.valueOf(k).charAt(0);
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ck) return i+1;
        }
        
        return -1;
    }
}