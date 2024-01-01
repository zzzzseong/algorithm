import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < seq.length; i++) {
            if(num > seq.length) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            while(num <= seq.length) {
                if(stack.isEmpty() || stack.peek() != seq[i]) {
                    num++;
                    stack.push(num);
                    sb.append("+").append("\n");
                } else {
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}