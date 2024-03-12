class Solution {
    public int solution(String A, String B) {
        
        int len = A.length();
        
        for(int i=len; i>=0; i--) {
            String str = A.substring(i, len) + A.substring(0, i);
                        
            if(B.equals(str)) return len-i;
        }
        
        return -1;
    }
}