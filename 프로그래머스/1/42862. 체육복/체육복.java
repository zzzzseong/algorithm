import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] closet = new boolean[n+1]; //1번 학생부터 n번 학생까지
        for(int r : reserve) {
            closet[r] = true;
        }
        
        Arrays.sort(lost);
        List<Integer> students = new ArrayList<>();
        for(int i=0; i<lost.length; i++) {
            int l = lost[i];
            if(closet[l]) closet[l] = false;
            else students.add(l);
        }
        
        int count = 0;
        for(int i=0; i<students.size(); i++) {
            int s = students.get(i);
            int fIdx = s-1;
            int bIdx = s+1;
            
            if(fIdx >= 1 && closet[fIdx]) {
                closet[fIdx] = false;
                count++;
                continue;
            }
            if(bIdx <= n && closet[bIdx]) {
                closet[bIdx] = false;
                count++;
            }
        }
                
        //13, 14 실패
        return n-students.size()+count;
    }
}