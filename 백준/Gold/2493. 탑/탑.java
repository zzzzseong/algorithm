import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Tower> stack = new Stack<>();
        stack.push(new Tower(1, towers[0]));

        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 1; i < N; i++) {

            while(!stack.isEmpty()) {
                Tower tower = stack.pop();

                if(towers[i] < tower.height) {
                    sb.append(" ").append(tower.idx);
                    stack.push(tower);
                    stack.push(new Tower(i+1, towers[i]));
                    break;
                }
            }

            if(stack.isEmpty()) {
                sb.append(" ").append(0);
                stack.push(new Tower(i+1, towers[i]));
            }
        }

        System.out.println(sb);
    }
}

class Tower {
    public int idx;
    public int height;

    public Tower(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}