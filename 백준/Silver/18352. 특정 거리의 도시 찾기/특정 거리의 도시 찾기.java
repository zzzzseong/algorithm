import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*BAEKJOON */
public class Main {
    private static int N, M, K, X; //도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호

    private static int[] minPath;
    private static final List<Set<Integer>> bucket = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        minPath[X] = 0;
        findMinCostPath(X);

        printAnswer();
    }

    public static void findMinCostPath(int city) {
        if(minPath[city] > K) return;

        Set<Integer> go = bucket.get(city);
        for (Integer g : go) {
            if(minPath[city] + 1 < minPath[g]) {
                minPath[g] = minPath[city] + 1;
                findMinCostPath(g);
            }
        }
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(minPath[i] == K) sb.append(i).append("\n");

        }
        if(Objects.equals(sb.toString(), "")) System.out.println(-1);
        else System.out.println(sb);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        K = Integer.parseInt(firstLine[2]);
        X = Integer.parseInt(firstLine[3]);

        minPath = new int[N+1];
        for (int i = 0; i <= N; i++) {
            minPath[i] = Integer.MAX_VALUE;
        }

        bucket.add(new HashSet<>());
        for (int i = 1; i <= N; i++) {
            bucket.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            String[] row = br.readLine().split(" ");
            bucket.get(Integer.parseInt(row[0])).add(Integer.parseInt(row[1]));
        }
    }
}