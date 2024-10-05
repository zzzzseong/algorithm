import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        List<Integer> answer = new ArrayList<>();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        int cur = 0;
        while(!list.isEmpty()) {
            int size = list.size();

            int tgt = cur + (K-1);
            if(tgt >= size) tgt %= size;

            answer.add(list.remove(tgt));

            cur = tgt >= size-1 ? 0 : tgt;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < answer.size() - 1; i++) {
            sb.append(answer.get(i)).append(", ");
        }

        sb.append(answer.get(answer.size()-1)).append(">");

        System.out.println(sb);
    }
}