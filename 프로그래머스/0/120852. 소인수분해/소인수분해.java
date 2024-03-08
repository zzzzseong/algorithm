import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        Set<Integer> set = new HashSet<>();
        
        while(n > 1) {
            for(int i=2; i<=n; i++) {
                if(n%i == 0) {
                    set.add(i);
                    n /= i;
                    break;
                }
            }
        }
        
        int[] answer = new int[set.size()];
        
        int idx = 0;
        for(int s : set) {
            answer[idx++] = s;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}