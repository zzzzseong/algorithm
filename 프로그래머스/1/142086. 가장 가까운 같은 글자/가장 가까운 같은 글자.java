import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] dist = new int[26];
        Arrays.fill(dist, -2);
        
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int distIdx = c - 'a'; //a -> 0, z -> 25
            
            if(dist[distIdx] == -2) answer[i] = -1;
            else answer[i] = i - dist[distIdx];
            
            dist[distIdx] = i;
        }
        
        return answer;
    }
}