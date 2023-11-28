class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        int answer = lcm(arr[0], arr[1]);
        
        for(int i=2; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while(b != 0) {
            int tmp = a;
            a = b;
            b = (tmp % a);
        }

        return a;
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}