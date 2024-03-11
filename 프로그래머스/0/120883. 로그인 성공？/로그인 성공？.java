class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        for(String[] data : db) {
            if(data[0].equals(id_pw[0])) {
                if(data[1].equals(id_pw[1])) return "login";
                else return "wrong pw";
            }
        }
        
        return "fail";
    }
}