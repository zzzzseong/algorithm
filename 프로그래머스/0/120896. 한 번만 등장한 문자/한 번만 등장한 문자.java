class Solution {
    public String solution(String s) {
        int[] a = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        
        String answer = "";
        for(int i=0; i<a.length; i++) {
            if(a[i] == 1) answer += (char)('a'+i);
        }
        
        return answer;
    }
}