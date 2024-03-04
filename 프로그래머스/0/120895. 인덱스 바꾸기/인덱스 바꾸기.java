class Solution {
    public String solution(String my_string, int num1, int num2) {
                
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        
        return my_string.substring(0, min) + my_string.charAt(max) + my_string.substring(min+1, max) + my_string.charAt(min) + my_string.substring(max+1);
        
    }
}