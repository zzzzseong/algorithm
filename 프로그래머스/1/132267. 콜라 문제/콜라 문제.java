class Solution {
    private int answer = 0;
    
    public int solution(int a, int b, int n) {
        recursive(a, b, n);
        return answer;
    }
    
    public void recursive(int a, int b, int n) {
        if(n < a) return;
        
        answer += n/a*b;
        recursive(a, b, n/a*b + n%a);
    }
}