import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int['z' + 1];

        arr['['] = 1;
        arr[']'] = 2;
        arr['('] = 3;
        arr[')'] = 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();
            if(".".equals(line)) break;

            Stack<Character> stack = new Stack<>();

            boolean yes = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(arr[c] == 1) stack.push(c);
                if(arr[c] == 3) stack.push(c);

                if(arr[c] == 2) {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        sb.append("no").append("\n");
                        yes = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if(arr[c] == 4) {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        sb.append("no").append("\n");
                        yes = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() && yes) sb.append("yes").append("\n");
            else if (yes) sb.append("no").append("\n");


        }

        System.out.println(sb);
    }
}