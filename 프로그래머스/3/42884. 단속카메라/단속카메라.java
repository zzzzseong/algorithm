import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        //도로진입시점 기준 오름차순 정렬
        Arrays.sort(routes, (r1, r2)->{
            if(r1[0] == r2[0]) return r1[1]-r2[1];
            return r1[0]-r2[0]; 
        });
        
        
        int answer = 1;
        int end = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            //이전 차량의 진출 지점이 현재 차량의 진입 지점보다 크거나 같다면
            if(routes[i][0] <= end) {
                if(routes[i][1] < end) end = routes[i][1];
                continue;
            }
            
            end = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}