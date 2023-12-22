class Solution {
    public String solution(String my_string) {
        int dist = 'A' - 'a';
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_string.length(); i++) {
            
            if('a' <= my_string.charAt(i) && my_string.charAt(i) <= 'z') {
                sb.append((char)(my_string.charAt(i) + dist));
            } else {
                sb.append((char)(my_string.charAt(i) - dist));
            }
        }
        
        return sb.toString();
    }
}