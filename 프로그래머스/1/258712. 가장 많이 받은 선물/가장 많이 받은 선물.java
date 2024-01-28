import java.util.*;

class Solution {   
    
    private int[][] matrix;
    
    public void init(String[] friends, String[] gifts) {
        
        int len = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++) {
            map.put(friends[i], i);
        }
        
        matrix = new int[len][len];
        
        for(int i=0; i<gifts.length; i++) {
            String[] fi = gifts[i].split(" ");
            
            matrix[map.get(fi[0])][map.get(fi[1])]++;
        }
        
    }
    
    public int solution(String[] friends, String[] gifts) {
        
        init(friends, gifts);
        
        int[] answer = new int[friends.length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix[i].length; j++) {
                //선물을 주고 받은적 없거나 같다면
                if(matrix[i][j] == matrix[j][i]) {
                    
                    int A = getScore(i);
                    int B = getScore(j);
                    
                    if(A == B) continue;
                    
                    if(A > B) answer[i]++;
                    else answer[j]++;
                    
                    continue;
                }
                
                
                if(matrix[i][j] > matrix[j][i]) answer[i]++;
                else answer[j]++;
            }
        }
        
        int max = 0;
        for(int i=0; i<answer.length; i++) {
            max = Math.max(max, answer[i]);
        }
        
        return max;
    }
    
    public int getScore(int num) {
        
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            sum += matrix[num][i];
        }
        for(int i=0; i<matrix.length; i++) {
            sum -= matrix[i][num];
        }
        
        return sum;
    }
}