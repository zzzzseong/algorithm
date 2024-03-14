import java.util.*;

class Solution {
    
    private List<Integer>[] graph;
    private int[] dist;
    
    public void init(int n, int[][] edge) {
        graph = new List[n+1];
        
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
    }
    
    public int solution(int n, int[][] edge) {
        init(n, edge);
        
        dijkstra(1);
                
        dist[0] = 0;
        Arrays.sort(dist);
        
        int answer = 1;
        for(int i=dist.length-2; i>0; i--) {            
            if(dist[i] == dist[dist.length-1]) answer++;
            else break;
        }
                
        return answer;
    }
    
    public void dijkstra(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(start);
        
        while(!dq.isEmpty()) {
            int cur = dq.removeFirst();
            
            List<Integer> nexts = graph[cur];
            
            for(int next : nexts) {
                if(dist[cur]+1 >= dist[next]) continue;
                
                dist[next] = dist[cur]+1;
                dq.addLast(next);
            }
        }
    }
}