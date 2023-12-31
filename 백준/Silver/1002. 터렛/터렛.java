import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");

            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int r1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int y2 = Integer.parseInt(line[4]);
            int r2 = Integer.parseInt(line[5]);

            if(x1 == x2 && y1 == y2 && r1 == r2) sb.append(-1).append("\n");
            else {
                int dx = (int) Math.pow(x1 - x2, 2);
                int dy = (int) Math.pow(y1 - y2, 2);

                double distance = Math.sqrt(dx + dy);

                if(distance > r1 + r2) sb.append(0).append("\n");
                else if(distance == r1 + r2) sb.append(1).append("\n");
                else if(distance + r2 < r1) sb.append(0).append("\n");
                else if(distance + r1 < r2) sb.append(0).append("\n");
                else if(distance + r1 == r2) sb.append(1).append("\n");
                else if(distance + r2 == r1) sb.append(1).append("\n");
                else sb.append(2).append("\n");
            }
        }

        System.out.println(sb);
    }
}