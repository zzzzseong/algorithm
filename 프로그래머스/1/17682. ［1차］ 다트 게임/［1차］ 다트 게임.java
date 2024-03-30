import java.util.Arrays;

class Solution {
    
    private String[] result;
    
    public void init(String dartResult) {
        result = new String[3];
        
        int rIdx = 0;
        int sIdx = 0;
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(c >= '0' && c <= '9' && i-sIdx > 1) {
                result[rIdx++] = dartResult.substring(sIdx, i);
                sIdx = i;
            }
        }
        result[rIdx] = dartResult.substring(sIdx);    
    }
    
    public int solution(String dartResult) {
        init(dartResult);
        
        int[] score = new int[3];
        for(int i=0; i<result.length; i++) {
            String r = result[i];
            for(int j=0; j<r.length(); j++) {
                char c = r.charAt(j);
                
                if(c == 'S' || c == 'D' || c == 'T') {
                    int num = Integer.parseInt(r.substring(0, j));
                    
                    if(c == 'D') num = (int) Math.pow(num, 2);
                    if(c == 'T') num = (int) Math.pow(num, 3);
                    
                    if(j != r.length()-1) {
                        char o = r.charAt(j+1);

                        if(o == '#') num = -num;
                        if(o == '*') {
                            num *= 2;
                            if(i > 0) score[i-1] *= 2;
                        }
                    }
                    
                    score[i] = num;
                    break;
                }
            }
        }
        
        int answer = 0;
        for(int s : score) answer += s;
        
        return answer;
    }
}