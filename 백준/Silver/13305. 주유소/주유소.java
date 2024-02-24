import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] node;
    private static int[] edge;

    private static long answer = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());

        node = new int[n1];
        edge = new int[n1 -1];

        String[] e = br.readLine().split(" ");
        for (int i = 0; i < e.length; i++) {
            edge[i] = Integer.parseInt(e[i]);
        }

        String[] n = br.readLine().split(" ");
        for (int i = 0; i < n.length; i++) {
            node[i] = Integer.parseInt(n[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int curIdx = 0;
        int curCost = node[curIdx];

        long sum = 0;
        for (int i = 1; i < node.length; i++) {
            sum += edge[i-1];

            if(i == node.length-1) {
                answer += node[curIdx]*sum;
                break;
            }

            if(node[i] < curCost) {
                answer += node[curIdx]*sum;

                sum = 0;

                curIdx = i;
                curCost = node[curIdx];
            }
        }

        System.out.println(answer);
    }
}

//1. current 도시에서 다음으로 주유비가 낮은곳까지의 이동거리만큼 주유한다.
//2. current 를 다음으로 주유비가 낮은 도시의 index로 이동.
//3. 마지막 도시가 나올때까지 반복한다.