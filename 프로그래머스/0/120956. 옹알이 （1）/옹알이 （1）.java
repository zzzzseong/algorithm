class Solution {
    public int solution(String[] babbling) {
        String[] strs = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        for(int i=0; i<babbling.length; i++) {
            String b = babbling[i];
                        
            for(int j=0; j<strs.length; j++) {
                b = b.replace(strs[j], " ");
            }
            
            b = b.replace(" ", "");
            
            if(b.length() == 0) answer++;
        }
        
        return answer;
    }
}