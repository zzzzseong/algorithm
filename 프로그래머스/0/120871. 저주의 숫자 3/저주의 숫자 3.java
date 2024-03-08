class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] numbers = new int[101];
        
        int num = 1;
        for(int i=1; i<=100; i++) {
            while(num%3 == 0 || contain(num)) {
                num++;
            }
            
            numbers[i] = num++;
        }
                
        return numbers[n];
    }
    
    public boolean contain(int num) {
        String n = String.valueOf(num);
        
        for(int i=0; i<n.length(); i++) {
            if(n.charAt(i) == '3') return true;
        }
        
        return false;
    }
}