import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String operation = br.readLine();
            switch (operation) {
                case "top":
                    if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.pop()).append("\n");
                    break;
                default:
                    String[] ops = operation.split(" ");
                    stack.push(Integer.parseInt(ops[1]));
                    break;
            }
        }

        System.out.println(sb);
    }
}
