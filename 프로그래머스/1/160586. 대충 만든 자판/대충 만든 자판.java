import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] dp = new int[26]; //0: A, 25: Z
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        //100*100
        for(int i=0; i<keymap.length; i++) {
            String key = keymap[i];
            
            for(int j=0; j<key.length(); j++) {
                int keyIdx = key.charAt(j) - 'A';
                if(dp[keyIdx] > j+1) dp[keyIdx] = j+1;
            }
        }
        
        //100*100
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            String target = targets[i];    
            
            for(int j=0; j<target.length(); j++) {
                int t = target.charAt(j) - 'A';
                if(dp[t] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += dp[t];
            }
        }
        
        return answer;
    }
}