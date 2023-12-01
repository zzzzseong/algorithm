import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private int[] circle;
    
    public void init(int[] elements) {
        circle = new int[elements.length*2];
        for(int i=0; i<elements.length; i++) {
            circle[i] = elements[i];
            circle[elements.length + i] = elements[i];
        }
    }
    
    public int solution(int[] elements) {
        init(elements);
        
        for(int i=0; i<elements.length; i++) {            
            for(int j=0; j<elements.length; j++) {
                set.add(Arrays.stream(circle, i, i+j).sum());
            }
        }
        
        return set.size();
    }
}