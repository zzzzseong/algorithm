import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*BAEKJOON */
public class Main {
    private static int V, E;
    private static int start;

    private static final List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();

        //정점의 갯수가 최대 20_000개이기 때문에 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if(dist[i] != Integer.MAX_VALUE) sb.append(dist[i]).append("\n");
            else sb.append("INF").append("\n");
        }

        System.out.println(sb);
     }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int curNode = node.getCurNode();

            List<Node> nextNodes = graph.get(curNode);
            for (Node nextNode : nextNodes) {
                int cost = nextNode.getCost();

                if(dist[curNode] + cost < dist[nextNode.getCurNode()]) {
                    dist[nextNode.getCurNode()] = dist[curNode] + cost;
                    pq.offer(new Node(nextNode.getCurNode(), dist[nextNode.getCurNode()]));
                }
            }

//            for (Node nextNode : nextNodes) {
//                int cost = nextNode.getCost();
//
//                if(dist[curNode] + cost < dist[nextNode.getCurNode()]) {
//                    dist[nextNode.getCurNode()] = dist[curNode] + cost;
//                    pq.offer(nextNode);
//                }
//            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        V = Integer.parseInt(firstLine[0]);
        E = Integer.parseInt(firstLine[1]);
        start = Integer.parseInt(br.readLine());

        graph.add(null);
        for (int i = 1; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");

            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int C = Integer.parseInt(line[2]);

            graph.get(A).add(new Node(B, C));
        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
    }
}

class Node implements Comparable<Node> {
    private final int curNode;
    private final int cost;

    public Node(int curNode, int cost) {
        this.curNode = curNode;
        this.cost = cost;
    }

    public int getCurNode() {
        return curNode;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(cost, n.getCost());
    }
}