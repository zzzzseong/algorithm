class Solution {
    public int solution(int i, int j, int k) {
        
        int answer = 0;
        for(int idx=i; idx<=j; idx++) {
            String number = String.valueOf(idx);
            
            for(int l=0; l<number.length(); l++) {
                if(number.charAt(l) == String.valueOf(k).charAt(0)) answer++;
            }
            
            // if(String.valueOf(idx).contains(String.valueOf(k))) answer++;
        }
        
        return answer;
    }
}