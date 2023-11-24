class Solution {
    public int solution(int n) {
        int[] sequence = new int[n+1];
        sequence[0] = 0;
        sequence[1] = 1;
        fibonacci(sequence, 2, n);
        return sequence[n] % 1_234_567;
    }
    
    public void fibonacci(int[] sequence, int f, int n) {
        if(f > n) return;
        
        sequence[f] = (sequence[f-1] + sequence[f-2]) % 1_234_567;
        fibonacci(sequence, f+1, n);
    }
}