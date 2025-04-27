import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws Exception {
        init();

        Queue<Integer> dummy = new LinkedList<>();

        for (int i = 1; i <= N; i++) dummy.offer(i);

        while(dummy.size() > 1) {
            dummy.poll();
            dummy.offer(dummy.poll());
        }

        System.out.println(dummy.poll());
    }
}