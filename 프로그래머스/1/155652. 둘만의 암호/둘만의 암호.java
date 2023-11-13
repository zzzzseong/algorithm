class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean[] dp = new boolean[26];
        for(int i=0; i<skip.length(); i++) {
            dp[skip.charAt(i) - 'a'] = true;
        }
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);            
            
            int count = index;
            while(count > 0) {
                char nc = (char) (c+1);
                if(nc > 'z') nc = 'a';
                
                if(!dp[nc - 'a']) count--;
                c = nc;
            }
            answer += c;
        }
        
        return answer;
    }
}