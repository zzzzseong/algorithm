class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<rsp.length(); i++) {
            if(rsp.charAt(i) == '2') {
                sb.append(0);
            } else if(rsp.charAt(i) == '5') {
                sb.append(2);
            } else {
                sb.append(5);
            }
        }
        
        return sb.toString();
    }
}