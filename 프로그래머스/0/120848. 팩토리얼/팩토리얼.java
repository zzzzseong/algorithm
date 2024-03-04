class Solution {
    public int solution(int n) {        
        return factorial(1, 1, n);
    }
    
    public int factorial(int i, int num, int n) {
        if(num > n) return i-2;
        
        return factorial(i+1, num*i, n);
    }
}