class Solution {
    public String[] solution(String[] quiz) {
        
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++) {
            String[] q = quiz[i].split(" ");
            
            int n1 = Integer.parseInt(q[0]);
            String op = q[1];
            int n2 = Integer.parseInt(q[2]);
            int n3 = Integer.parseInt(q[4]);
            
            if("-".equals(op)) {
                if(n1-n2 == n3) answer[i] = "O";
                else answer[i] = "X";
            } else {
                if(n1+n2 == n3) answer[i] = "O";
                else answer[i] = "X";
            }
        }
        
        return answer;
    }
}