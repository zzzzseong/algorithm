import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int T, N;

    private static int A, B;

    public static int[] init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] parents = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            String[] line = br.readLine().split(" ");
            parents[Integer.parseInt(line[1])] = Integer.parseInt(line[0]);
        }

        String[] line = br.readLine().split(" ");

        A = Integer.parseInt(line[0]);
        B = Integer.parseInt(line[1]);

        return parents;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int[] parents = init(br);

            List<Integer> list = new ArrayList<>();

            int cur = A;
            while(cur != 0) {
                list.add(cur);
                cur = parents[cur];
            }

            cur = B;
            boolean run = true;

            while(run) {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) == cur) {
                        sb.append(cur).append("\n");
                        run = false;
                        break;
                    }
                }

                cur = parents[cur];
            }
        }

        System.out.println(sb);
    }
}