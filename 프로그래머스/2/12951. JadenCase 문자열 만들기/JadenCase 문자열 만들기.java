class Solution {
    public String solution(String s) {
        String[] jadenCase = s.toLowerCase().split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<jadenCase.length; i++) {
            if("".equals(jadenCase[i])) {
                sb.append(" ");
                continue;
            }
            
            if(jadenCase[i].charAt(0) >= 'a' && jadenCase[i].charAt(0) <= 'z') {
                sb.append((char)('A' + (jadenCase[i].charAt(0) - 'a')));
                sb.append(jadenCase[i].substring(1, jadenCase[i].length()));
            } else {
                sb.append(jadenCase[i]);   
            }
            sb.append(" ");
        }
        
        return sb.toString().substring(0, sb.length()-1);
    }
}