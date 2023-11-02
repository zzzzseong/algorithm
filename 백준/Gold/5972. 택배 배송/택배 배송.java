import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}

/*BAEKJOON */
public class Main {
    private static int N, E;
    private static final List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        init();

        dijkstra();

        System.out.println(dist[N]);
     }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int curNode = node.getCurNode();

            List<Node> nextNodes = graph.get(curNode);
            for (int i = 0; i < nextNodes.size(); i++) {
                Node nextNode = nextNodes.get(i); //1-> n으로 가는 node 번호와 cost를 담고 있거임.
                int cost = nextNode.getCost();

                if(dist[curNode] + cost < dist[nextNode.getCurNode()]) {
                    dist[nextNode.getCurNode()] = dist[curNode] + cost;
                    pq.offer(nextNode);
                }
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        E = Integer.parseInt(firstLine[1]);

        graph.add(null);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int C = Integer.parseInt(line[2]);

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        dist = new int[N+1];
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }
}