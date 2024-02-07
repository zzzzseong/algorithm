import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        sb.append((int)Math.pow(2, N)-1).append("\n");

        hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void hanoi(int N, int s, int m, int e) {
        if(N == 1) {
            sb.append(s).append(" ").append(e).append("\n");
            return;
        }

        hanoi(N-1, s, e, m);
        sb.append(s).append(" ").append(e).append("\n");
        hanoi(N-1, m, s, e);
    }
}