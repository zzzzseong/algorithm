class Solution {
    public String solution(String polynomial) {
        
        String[] strs = polynomial.split(" ");
        
        int x = 0;
        int num = 0;
        
        for(int i=0; i<strs.length; i++) {
            if("+".equals(strs[i])) continue;
            
            if(strs[i].contains("x")) {
                if(strs[i].length() == 1) {
                    x++;
                    continue;
                }
                x += Integer.parseInt(strs[i].substring(0, strs[i].length()-1));
            }
            else num += Integer.parseInt(strs[i]);
        }
        
        String answer = "";
        
        if(x != 0) {
            if(x == 1) answer += "x";
            else answer += x + "x";
        }
        
        if(num != 0) {
            if(x != 0) answer += " + " + num;
            else answer += num;
        }
        
        return answer;
    }
}