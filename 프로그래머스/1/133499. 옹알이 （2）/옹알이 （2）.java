import java.util.Objects;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String b : babbling) {
            if(b.length() == 1) continue;
            String prev = "";
            
            while(true) {
                boolean can = false;
                for(int i=0; i<words.length; i++) {
                    int len = words[i].length();
                    if(len > b.length()) len = b.length();
                    
                    String subb = b.substring(0, len);                    
                    if(Objects.equals(subb, words[i]) && !Objects.equals(subb, prev)) {
                        if(b.length() > len) b = b.substring(len, b.length());
                        else b = "";
                        prev = subb;
                        can = true;
                        break;
                    }
                }
                
                if(!can) break;
                if(Objects.equals(b, "")) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}