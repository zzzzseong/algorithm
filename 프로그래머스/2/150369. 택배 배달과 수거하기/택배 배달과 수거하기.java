class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int i = n-1;
        while(i >= 0) {
            if(deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            answer += (i+1)*2;
            
            //배달할 택배 상자를 구하는 과정
            int dc = 0;
            for(int j=i; j>=0; j--) {
                if(dc + deliveries[j] > cap) {
                    deliveries[j] -= (cap-dc);
                    break;
                }
                
                dc += deliveries[j];
                deliveries[j] = 0;
            }
            
            //수거할 택배 상자를 구하는 과정
            int pc = 0;
            for(int j=i; j>=0; j--) {
                if(pc + pickups[j] > cap) {
                    pickups[j] -= (cap-pc);
                    break;
                }
                
                pc += pickups[j];
                pickups[j] = 0;
            }
        }
        
        return answer;
    }
}