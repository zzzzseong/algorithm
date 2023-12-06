class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left) + 1];
        
        int idx = 0;
        for(long i=left; i<=right; i++) {
            long col = i % n; //2
            long row = i / n; //0
            
            answer[idx++] = (int) Math.max(col, row) + 1;
        }
        
        return answer;
    }
}

// 0, 1, 2

// 1, 2, 3
// 2, 2, 3
// 3, 3, 3

// n <= 10_000_000

//열과 행 중 큰 값 + 1을 하면 i,j의 값을 알 수 있다.
