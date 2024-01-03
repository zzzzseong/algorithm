import java.util.*;

class Solution {
    private List<Node>[] graph;
    private int[] dist;
    
    public void init (int N, int[][] road) {
        graph = new List[N+1];
        graph[0] = null;
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++) {
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
    }
    
    public int solution(int N, int[][] road, int K) {
        init(N, road);
        
        dijkstra(1);

        int answer = 0;
        for(int i=1; i<dist.length; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            List<Node> nexts = graph[cur.getNode()];
            for(Node next : nexts) {
                int cost = next.getCost();
                
                if(dist[cur.getNode()] + cost < dist[next.getNode()]) {
                    dist[next.getNode()] = dist[cur.getNode()] + cost;
                    
                    pq.offer(new Node(next.getNode(), dist[next.getNode()]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    private final int node;
    private final int cost;
    
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    public int getNode() {
        return node;
    }
    
    public int getCost() {
        return cost;
    }
    
    @Override
    public int compareTo(Node n) {
        return Integer.compare(cost, n.cost);
    }
}