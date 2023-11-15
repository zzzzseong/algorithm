class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char a = s.charAt(0);
        int aCount = 1;
        int bCount = 0;
        int len = s.length();
        for(int i=1; i<len; i++) {
            if(s.charAt(i) == a) aCount++;
            else bCount++;
            
            if(aCount == bCount) {
                answer++;
                i++;
                if(i < len) {
                    a = s.charAt(i);
                    aCount = 1;
                    bCount = 0;
                }
            }
            
            if(i == len-1) answer++;
        }
        
        if(len == 1) answer++;
        return answer;
    }
}