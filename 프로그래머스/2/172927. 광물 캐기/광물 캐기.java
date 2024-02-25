import java.util.*;

class Solution {
    
    //광물 피로도 표
    private Map<String, int[]> map = new HashMap<>();
    
    private int answer = Integer.MAX_VALUE;
    
    public void init() {
        //다이아를 다이아, 철, 돌 곡괭이로 캤을때의 피로도
        int[] dia = {1, 5, 25};
        int[] iron = {1, 1, 5};
        int[] stone = {1, 1, 1};
        
        map.put("diamond", dia);
        map.put("iron", iron);
        map.put("stone", stone);
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        init();
        
        combination(picks, minerals, 0, 0, 0);
        
        return answer;
    }
    
    public void combination(int[] picks, String[] minerals, int idx, int r, int sum) {
        //광산의 끝에 도달했다면 종료
        if(idx == minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }
        
        //사용가능한 곡괭이가 없다면 종료
        boolean isEmpty = false;
        for(int i=0; i<picks.length; i++) {
            if(picks[i] != 0) isEmpty = true;
        }
        if(!isEmpty) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i=0; i<picks.length; i++) {
            if(picks[i] == 0) continue;
            
            picks[i]--;
            int cnt = 0;
            int nSum = sum;
            int nIdx = idx;
            while(nIdx < minerals.length) {
                if(cnt == 5) break;
                nSum += map.get(minerals[nIdx++])[i];
                cnt++;
            }
            
            combination(picks, minerals, nIdx, r+1, nSum);
            picks[i]++;
        }
        
    }
}

//1. 곡괭이별로 광물을 캘때 서로다른 피로도가 발생한다
//2. 모든 곡괭이는 5개의 광물을 캔 후 더이상 사용할 수 없다.
//3. 한 번 선택한 곡괭이는 무조건 5번 사용해야한다.
//4. 더 사용할 곡괭이가 없거나, 캘 수 있는 광물이 없는 경우 끝.
//5. 작업을 끝내기까지 필요한 최소한의 피로도를 return.

//다이아, 돌, 돌, 돌, 돌, 다이아, 다이아, 다이아, 다이아, 다이아

//minerals <= 50 : 곡괭이는 15개가 있어도 최대 10개밖에 사용할 수 없다.
//최대 3^10