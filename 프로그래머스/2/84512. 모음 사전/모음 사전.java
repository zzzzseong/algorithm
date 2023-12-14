class Solution {
    private char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    private boolean find = false;
    private int count = 0;
    private int answer = 0;
    
    public int solution(String word) {        
        for(int i=0; i<alphabet.length; i++) {
            count++;
            dfs(word, "" + alphabet[i], 1);
        }

        return answer;
    }
    
    public void dfs(String target, String str, int depth) {        
        if(target.equals(str)) {
            answer = count;
            return;
        }
        if(depth == alphabet.length) return;
        
        for(int i=0; i<alphabet.length; i++) {
            count++;
            dfs(target, str + alphabet[i], depth+1);
        }
    }
}