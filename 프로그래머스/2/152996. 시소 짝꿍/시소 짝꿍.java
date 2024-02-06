import java.util.*;

class Solution {
    private Map<Integer, Long> wm = new HashMap<>();
    private Map<Integer, Long> map = new HashMap<>();
    
    private long answer = 0;
    
    private void init(int[] weights) {
        for(int w : weights) {
            if(wm.get(w) == null) {
                wm.put(w, 1L);
                continue;
            }
            
            answer += wm.get(w);
            wm.put(w, wm.get(w)+1);
        }
    }
    
    public long solution(int[] weights) {
        init(weights);
        
        for(Integer key : wm.keySet()) {
            setMap(key, key*2);
            setMap(key, key*3);
            setMap(key, key*4);
        }
        
        return answer;
    }
    
    public void setMap(int key, int mKey) {
        if(map.get(mKey) == null) {
            map.put(mKey, wm.get(key));
        } else {
            answer += map.get(mKey)*wm.get(key);
            map.put(mKey, map.get(mKey) + wm.get(key));
        }
    }
}