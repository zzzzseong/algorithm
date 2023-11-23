class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        binaryConverter(s, answer);
        return answer;
    }
    
    public void binaryConverter(String s, int[] answer) {
        if("1".equals(s)) return;
        
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') count++;
        }

        answer[0]++;
        answer[1] += count;
        binaryConverter(Integer.toString(s.length()-count, 2), answer);
    }
}