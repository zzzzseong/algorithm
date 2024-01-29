class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int pc = 0;
        int yc = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p') pc++;
            if(c == 'y') yc++;
        }

        return (pc == yc) ? true : false;
    }
}