import java.util.*;

class Solution {
    private int[][] net;
    
    public void init(int n, int[][] wires) {
        net = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++) {
            net[wires[i][0]][wires[i][1]] = 1;
            net[wires[i][1]][wires[i][0]] = 1;
        }
    }
    
    public int solution(int n, int[][] wires) {
        init(n, wires);
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<wires.length; i++) {
            //전력망 끊어주기
            net[wires[i][0]][wires[i][1]] = 0;
            net[wires[i][1]][wires[i][0]] = 0;
                        
            int tmp = bfs(n);
            answer = Math.min(answer, Math.abs(tmp - Math.abs(n - tmp)));
            
            //전력망 연결하기
            net[wires[i][0]][wires[i][1]] = 1;
            net[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        
        boolean[] vis = new boolean[n+1];
        
        int count = 0;
        while(!queue.isEmpty()) {
            count++;
            
            int cur = queue.poll();
            vis[cur] = true;
            
            for(int i=0; i<net[cur].length; i++) {
                if(net[cur][i] == 1 && !vis[i]) queue.offer(i);
            }
        }
        
        return count;
    }
}