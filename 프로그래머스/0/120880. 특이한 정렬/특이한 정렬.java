import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        Integer[] nums = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        
        Arrays.sort(nums, (o1, o2)->{
            int n1 = Math.abs(o1-n);
            int n2 = Math.abs(o2-n);
            
            if(n1 == n2) return o2-o1;
            
            return n1-n2;
        });
        
        return Arrays.stream(nums).mapToInt(i->i).toArray();
    }
}