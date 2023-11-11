class Solution {
    public int[] solution(int n, int m) { 
        if(n > m) {
            int[] answer = {gcd(n, m), lcm(n, m)};
            return answer;
        } else {
            int[] answer = {gcd(m, n), lcm(m, n)};
            return answer;
        }
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

