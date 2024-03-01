import java.util.*;

class Solution {
    
    private final List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] arr, boolean[] flag) {
        
        for(int i=0; i<flag.length; i++) {
            if(flag[i]) {
                for(int j=0; j<arr[i]*2; j++) {
                    list.add(arr[i]);
                }
            } else {
                for(int j=0; j<arr[i]; j++) {
                    list.remove(list.size()-1);
                }
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}