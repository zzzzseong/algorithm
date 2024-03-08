class Solution {
    public int solution(String[] spell, String[] dic) {
        
        int answer = 0;
        for(int i=0; i<dic.length; i++) {
            int[] d = new int[26];
            
            for(int j=0; j<dic[i].length(); j++) {
                d[dic[i].charAt(j)-'a']++;
            }
            
            if(isExist(d, spell)) answer++;
        }
        
        return answer >= 1 ? 1 : 2;
    }
    
    public boolean isExist(int[] d, String[] spell) {
        for(int j=0; j<spell.length; j++) {
            if(d[spell[j].charAt(0)-'a'] != 1) return false;
        }
        return true;
    }
}