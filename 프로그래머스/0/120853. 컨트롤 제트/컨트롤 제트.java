class Solution {
    public int solution(String s) {
        
        String[] strs = s.split(" ");
        
        int answer = 0;
        for(int i=0; i<strs.length; i++) {
            if("Z".equals(strs[i])) {
                answer -= Integer.parseInt(strs[i-1]);
            } else {
                answer += Integer.parseInt(strs[i]);
            }
        }
        
        return answer;
    }
}