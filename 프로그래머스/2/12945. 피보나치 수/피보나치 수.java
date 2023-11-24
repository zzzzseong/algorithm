class Solution {
    public int solution(int n) {
        int[] sequence = new int[n+1];
        sequence[0] = 0;
        sequence[1] = 1;
        
        for(int i=2; i<=n; i++) {
            sequence[i] = (sequence[i-1] + sequence[i-2]) % 1_234_567;
        }
        return sequence[n] % 1_234_567;
    }
}