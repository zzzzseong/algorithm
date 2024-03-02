class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        
        int max = Math.max(row, col);
        
        int[][] answer = new int[max][max];
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}