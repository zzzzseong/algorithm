import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        boolean[] vis = new boolean[numbers.length];
        combination(numbers, vis, 0, 2, 0);
        
        int[] answer = new int[set.size()];
        int i = 0;
        for(Integer num : set) {
            System.out.print(num + " ");
            answer[i++] = num;
        }
     
        Arrays.sort(answer);
        return answer;
    }
    
    public void combination(int[] numbers, boolean[] vis, int sIdx, int r, int sum) {
        if(r == 0) {
            set.add(sum);
            return;
        }
        
        for(int i=sIdx; i<numbers.length; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            combination(numbers, vis, i+1, r-1, sum+numbers[i]);
            vis[i] = false;
        }
    }
}