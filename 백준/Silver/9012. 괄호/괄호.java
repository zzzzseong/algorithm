import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] ps = br.readLine().split("");

            if(vps(ps)) sb.append("YES\n");
            else sb.append("NO\n");

            stack.clear();
        }

        System.out.println(sb);
    }

    public static boolean vps(String[] ps) {
        for (int i = 0; i < ps.length; i++) {
            if("(".equals(ps[i])) {
                stack.push(ps[i]);
            } else {
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
