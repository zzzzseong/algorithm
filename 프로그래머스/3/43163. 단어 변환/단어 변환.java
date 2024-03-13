import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> map = new HashMap<>();
    
    private boolean[] vis;
    
    private int answer = Integer.MAX_VALUE;
    
    public void init(String begin, String target, String[] words) {
        
        map.put(begin, new ArrayList<>());
        
        for(int i=0; i<words.length; i++) {
            map.put(words[i], new ArrayList<>());
            
            int count = 0;
            for(int j=0; j<words[i].length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) count++;
            }
                
            if(count == 1) {
                map.get(begin).add(i);
                map.get(words[i]).add(-1);
            }
        }
        
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length; j++) {
                if(i==j) continue;
                
                int count = 0;
                for(int k=0; k<words[i].length(); k++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) count++;
                }
                
                if(count == 1) map.get(words[i]).add(j);
            }
        }
        
        vis = new boolean[words.length];
    }
    
    public int solution(String begin, String target, String[] words) {
        
        init(begin, target, words);
        
        if(map.get(target) == null || map.get(target).isEmpty()) return 0;
        
        dfs(begin, target, 0, words);
        
        return answer;
    }
    
    public void dfs(String cur, String target, int depth, String[] words) {
        
        if(target.equals(cur)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        List<Integer> nexts = map.get(cur);
        
        for(int i=0; i<nexts.size(); i++) {
            int next = nexts.get(i);
            
            if(next == -1 || vis[next]) continue;
            
            vis[next] = true;
            dfs(words[next], target, depth+1, words);
            vis[next] = false;
        }
    }
}