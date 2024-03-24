import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stage = new int[N+1];
        
        //스테이지별로 몇 명의 사용자가 머물러 있는지 저장하는 로직
        for(int i=0; i<stages.length; i++) {
            
            //마지막 스테이지에 도달한 플레이어 제외
            if(stages[i] == N+1) continue;
            stage[stages[i]]++;
        }
        
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        int player = stages.length;
        
        //1번 스테이지부터 N번 스테이지까지 실패율 계산 후 pq에 삽입
        for(int i=1; i<stage.length; i++) {
            double p;
            
            if(player == 0) p = 0;
            else p=(double)stage[i]/(double)player;
            
            System.out.println(p);
            pq.offer(new Stage(i, p));
            player -= stage[i];
        }
        
        int[] answer = new int[N];
        for(int i=0; i<answer.length; i++) {
            Stage st = pq.poll();
            answer[i] = st.getNum();
        }
        
        return answer;
    }
}

class Stage implements Comparable<Stage> {
    
    //stage number
    private int num;
    private double p;
    
    public Stage(int num, double p) {
        this.num = num;
        this.p = p;
    }
    
    public int getNum() {
        return num;
    }
    
    public double getP() {
        return p;
    }
    
    @Override
    public int compareTo(Stage s) {
        //실패율이 같다면 스테이지 번호 오름차순
        if(this.p == s.p) {
            return this.num-s.num;
        }
        
        //실패율 기준 내림차순
        if(this.p > s.p) return -1;
        else return 1;
    }
}