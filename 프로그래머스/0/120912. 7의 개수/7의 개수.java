class Solution {
    public int solution(int[] array) {
        String str = "";
        
        for(int i=0; i<array.length; i++) {
            str += array[i];
        }
        
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '7') answer++;
        }
        
        return answer;
    }
}