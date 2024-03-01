class Solution {
    public String solution(String my_string, int s, int e) {
        String f = my_string.substring(0, s);
        String snd = my_string.substring(s, e+1);
        
        String ns = "";
        for(int i=snd.length()-1; i>=0; i--) {
            ns += snd.charAt(i);
        }
        
        String t = "";
        if(e+1 != my_string.length()) {
            t = my_string.substring(e+1, my_string.length());
        }
        
        return f + ns + t;
    }
}