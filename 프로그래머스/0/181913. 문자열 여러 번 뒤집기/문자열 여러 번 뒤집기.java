class Solution {
    public String solution(String my_string, int[][] queries) {
        
        for(int i=0; i<queries.length; i++) {
            String s = my_string.substring(queries[i][0], queries[i][1]+1);
            
            StringBuffer sb = new StringBuffer(s);
            s = sb.reverse().toString();
            
            my_string = my_string.substring(0, queries[i][0]) + s + my_string.substring(queries[i][1]+1, my_string.length());
        }
        
        return my_string;
    }
}