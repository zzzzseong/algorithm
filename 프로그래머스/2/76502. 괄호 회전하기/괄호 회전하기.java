class Solution {
    public int solution(String s) {
        String[] validStrings = {"\\[]", "\\(\\)", "\\{}"};
        
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            //i부터 s.length()+1까지 substring + i부터 i까지 substring
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            while(str.length() != 0) {
                int len = str.length();

                for(String vs : validStrings) {
                    str = str.replaceAll(vs, "");
                }

                if(len == str.length()) break;
                if(str.length() == 0) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}