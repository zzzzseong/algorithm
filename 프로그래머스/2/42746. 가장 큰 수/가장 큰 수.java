import java.util.*;

class Solution {    
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        //가장 큰 수가 0이라면
        if("0".equals(nums[0])) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}