class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        
        int aIdx = 0;
        for(int i=0; i<picture.length; i++) {
            String s = "";
            
            for(int j=0; j<picture[i].length(); j++) {
                for(int l=0; l<k; l++) {
                    s += picture[i].charAt(j);
                }
            }
            
            for(int j=0; j<k; j++) {
                answer[aIdx++] = s;
            }
        }
        
        return answer;
    }
}