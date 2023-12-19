class Solution {
    public String solution(String number, int k) {
                
        StringBuilder sb = new StringBuilder();
        
        int sIdx = 0;
        while(true) {
            char max = number.charAt(sIdx);
            int maxIdx = sIdx;
            
            for(int i=sIdx+1; i<=sIdx+k; i++) {
                char cur = number.charAt(i);
                
                if(cur > max) {
                    max = cur;
                    maxIdx = i;
                }
            }
            
            sb.append(number.charAt(maxIdx));
            
            k -= (maxIdx-sIdx);
            sIdx = maxIdx + 1;
                         
            if(number.length()-sIdx <= k) break;
            if(k < 0) {
                sb.append(number.substring(sIdx, number.length()));
                break;
            }
        }
        
        return sb.toString();
    }
}