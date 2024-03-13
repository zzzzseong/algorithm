import java.util.*;

class Solution {
    
    private boolean[] vis;
    private List<Integer>[] graph;
        
    public void init(int n, int[][] computers) {
        vis = new boolean[n];
        graph = new List[n];
    
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                if(computers[i][j] == 1) graph[i].add(j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        init(n, computers);
        
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(vis[i]) continue;
            
            answer++; 
            network(i);
        }
        
        return answer;
    }
    
    public void network(int node) {
        
        vis[node] = true;
        
        List<Integer> nexts = graph[node];
        
        for(int i=0; i<nexts.size(); i++) {
            int next = nexts.get(i);
            
            if(vis[next]) continue;
            
            network(next);
        }
    }
}