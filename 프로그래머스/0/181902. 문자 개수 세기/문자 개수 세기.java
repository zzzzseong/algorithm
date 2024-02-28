class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
                
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if('A' <= c && 'Z' >= c) answer[c-'A']++;
            else answer[c-'A'-6]++;
        }        
        
        return answer;
    }
}