import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        while(i < arr.length) {
            if(list.isEmpty()) {
                list.add(arr[i++]);
                continue;
            }
            
            if(list.get(list.size()-1) == arr[i]) {
                list.remove(list.size()-1);
                i++;
                continue;
            }
            
            if(list.get(list.size()-1) != arr[i]) {
                list.add(arr[i++]);
                continue;
            }
        }
        
        if(list.isEmpty()) {
            int[] ret = {-1};
            return ret;
        }
        
        return list.stream().mapToInt(I->I).toArray();
    }
}