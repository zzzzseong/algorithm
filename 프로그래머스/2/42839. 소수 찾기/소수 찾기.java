import java.util.*;

class Solution {    
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        String[] nums = numbers.split("");
        boolean[] vis = new boolean[nums.length];
        
        dfs(nums, vis, "", 0);
        
        return set.size();
    }
    
    public void dfs(String[] nums, boolean[] vis, String str, int depth) {
        isPrime(str);
        
        if(depth == nums.length) return;
        
        for(int i=0; i<nums.length; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            dfs(nums, vis, str + nums[i], depth+1);
            vis[i] = false;
        }
    }
    
    public void isPrime(String num) {
        if("".equals(num)) return;
        
        int intNum = Integer.parseInt(num);
        if(intNum == 0 || intNum == 1) return;
        
        double sqrt = Math.sqrt(intNum);
        for(int i=2; i<=sqrt; i++) {
            if(intNum%i == 0) return;
        }
        
        set.add(intNum);
    }
}