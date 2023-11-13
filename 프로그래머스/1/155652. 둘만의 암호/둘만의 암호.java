class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 50*10*20
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            //z
            
            int count = index;
            while(count > 0) {
                char nc = (char) (c+1);
                if(nc > 'z') nc = 'a'; //a
                
                boolean canSkip = false;
                for(int j=0; j<skip.length(); j++) {
                    if(nc == skip.charAt(j)) {
                        canSkip = true;
                        break;
                    }
                }
                
                if(!canSkip) count--;    
                c = nc;
            }
            
            answer += c;
        }
        
        return answer;
    }
}