import java.util.Objects;

class Solution {
    public String solution(String[] seoul) {
        int i;
        for(i=0; i<seoul.length; i++) {
            if(Objects.equals(seoul[i], "Kim")) break;
        }
        
        return "김서방은 " + i + "에 있다";
    }
}