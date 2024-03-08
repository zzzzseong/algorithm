class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        
        int sum = Integer.parseInt(arr[0]);
        
        for(int i=1; i<arr.length; i+=2) {
            int num = Integer.parseInt(arr[i+1]);
            sum += "+".equals(arr[i]) ? num : -num;
        }
        
        return sum;
    }
}