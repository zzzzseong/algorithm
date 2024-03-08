class Solution {
    
    private int answer = 0;
    
    public int solution(int balls, int share) {
        
        combination(1, 0, balls, share);
        
        return answer;
    }
    
    
    public void combination(int sIdx, int depth, int balls, int share) {
        if(depth == share) {
            answer++;
            return;
        }
     
        for(int i=sIdx; i<=balls; i++) {
            combination(i+1, depth+1, balls, share);
        }
    }
}