import java.util.Arrays;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        Arrays.sort(attacks, (o1, o2)->{
           return o1[0]-o2[0]; 
        });
        
        int len = attacks[attacks.length-1][0];
        int HP = health;
        
        int aIdx = 0;
        if(attacks[aIdx][0] == 0) HP -= attacks[aIdx++][1];
        if(HP < 0) return -1;
        
        int h = 0;
        for(int time=0; time<=len; time++) {            
            if(aIdx < attacks.length && attacks[aIdx][0] == time) {
                HP -= attacks[aIdx++][1];
                h = 0;
                
                if(HP <= 0) return -1;
                else continue;
            }
            
            HP += bandage[1];
            
            if(++h == bandage[0]) {
                HP += bandage[2];
                h = 0;
            }
            
            if(HP > health) HP = health;
        }
        
        return HP;
    }
}