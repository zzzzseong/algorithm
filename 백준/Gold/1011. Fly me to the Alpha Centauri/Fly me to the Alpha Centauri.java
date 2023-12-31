import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");

            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            int distance = end - start;

            int max = (int) Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                sb.append(max*2 - 1).append("\n");
            }
            else if(distance <= max * max + max) {
                sb.append(max*2).append("\n");
            }
            else {
                sb.append(max * 2 + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
