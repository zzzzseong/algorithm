import java.util.Objects;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int distance = p.length();
        for(int i=0; i<=t.length()-distance; i++) {
            String num = t.substring(i, i+distance);
            
            for(int j=0; j<num.length(); j++) {
                if(num.charAt(j) == p.charAt(j)) continue;
                if(num.charAt(j) < p.charAt(j)) answer++;   
                break;
            }
            
            if(Objects.equals(num, p)) answer++;
        }
        
        return answer;
    }
}