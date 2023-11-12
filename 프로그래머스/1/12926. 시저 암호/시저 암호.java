import java.util.Objects;

class Solution {
    public String solution(String s, int n) {        
        String[] words = s.split(" ", -1);
        
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            if(Objects.equals(word, "")) {
                sb.append(" ");
                continue;
            }
            
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                char nc = (char) (c + n);
                
                if(c >= 'a' && c <= 'z') { //lowercase
                    if(nc > 'z') sb.append((char)('a' + (nc - 'z' -1)));
                    else sb.append(nc);
                }
                if(c >= 'A' && c <= 'Z') { //uppercase
                    if(nc > 'Z') sb.append((char)('A' + (nc - 'Z' -1)));
                    else sb.append(nc);
                }
            }
            
            sb.append(" ");
        }
        
        String answer = sb.toString();
        return answer.substring(0, answer.length()-1);
    }
}