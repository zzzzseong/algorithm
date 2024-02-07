import java.util.*;

class Solution {
    
    private List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            int[] e = list.get(i);
            
            answer[i][0] = e[0];
            answer[i][1] = e[1];
        }
        
        return answer;
    }
    
    public void hanoi(int N, int s, int m, int e) {
        if(N==1) {
            int[] arr = {s, e};
            list.add(arr);
            return;
        }
        
        hanoi(N-1, s, e, m);
        
        int[] arr = {s, e};
        list.add(arr);
        
        hanoi(N-1, m, s, e);
    }
}