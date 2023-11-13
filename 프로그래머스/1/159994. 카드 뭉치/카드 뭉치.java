import java.util.Objects;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {        
        int left = 0; //cards1 Idx
        int right = 0; //cards2 Idx
        for(int i=0; i<goal.length; i++) {
            String word = goal[i];
            if(left < cards1.length && Objects.equals(word, cards1[left])) left++;
            else if(right < cards2.length && Objects.equals(word, cards2[right])) right++;
            else return "No";
        }
        
        return "Yes";
    }
}