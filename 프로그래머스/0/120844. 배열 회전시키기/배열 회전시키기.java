import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        int start, end;
        
        List<Integer> list = new ArrayList<>();
        
        if("right".equals(direction)) {
            start = 0;
            end = numbers.length-1;
            list.add(numbers[numbers.length-1]);
        } else {
            start = 1;
            end = numbers.length;
        }
        
        for(int i=start; i<end; i++) {
            list.add(numbers[i]);
        }
        
        if("left".equals(direction)) list.add(numbers[0]);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}