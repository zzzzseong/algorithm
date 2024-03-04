class Solution {
    public int solution(String before, String after) {
        
        int[] a = new int[26];
        
        for(int i=0; i<before.length(); i++) {
            a[before.charAt(i)-'a']++;
        }
        
        for(int i=0; i<after.length(); i++) {
            char c = after.charAt(i);
            a[c-'a']--;
            
            if(a[c-'a'] < 0) return 0;
        }
        
        return 1;
    }
}