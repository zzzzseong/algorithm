import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        String[] targets = br.readLine().split(" ");

        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(targets[i]);
        }

        int count = 0;
        for (int i = 0; i < target.length; i++) {
            //1. q에서 target[i]가 있는 idx를 찾는다.
            //2. 가까운 방향으로 회전하거나 q에서 pop
            //3. 회전 시에는 count를 올려준다.

            int idx = 0;
            for (Integer e : q) {
                if(e == target[i]) break;
                idx++;
            }

            if(q.size()-idx >= idx) {
                //왼쪽 k번 회전하고 pop
                for (int j = 0; j < idx; j++) {
                    q.offer(q.pop());
                    count++;
                }
                q.pop();

            } else {
                //오른쪽 j번 회전 회전하고 pop
                for (int j = 0; j < q.size() - idx; j++) {
                    q.addFirst(q.removeLast());
                    count++;
                }
                q.pop();
            }
        }

        System.out.println(count);
    }
}