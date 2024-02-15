class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int[] q : queries) {
            swap(arr, q);
        }
        
        return arr;
    }
    
    public void swap(int[] arr, int[] idxs) {
        int tmp = arr[idxs[0]];
        arr[idxs[0]] = arr[idxs[1]];
        arr[idxs[1]] = tmp;
    }
}