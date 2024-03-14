import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] str = myString.split("x");
        
        List<String> list = new ArrayList<>();
        
        for(String s : str) {
            if("".equals(s)) continue;
            
            list.add(s);
        }
                
        list.sort(Comparator.naturalOrder());
            
        return list.stream().toArray(String[]::new);
    }
}