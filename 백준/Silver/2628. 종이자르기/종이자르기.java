import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * B2628(실버5) - 종이자르기
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> xPos = new PriorityQueue<>();
        PriorityQueue<Integer> yPos = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");

            int dir = Integer.parseInt(line[0]);
            int pos = Integer.parseInt(line[1]);

            if(dir == 0) xPos.offer(pos);
            if(dir == 1) yPos.offer(pos);
        }

        //maxX, curX, maxY, curY
        int[] v = new int[4];
        while(!xPos.isEmpty()) {
            int x = xPos.poll();
            v[0] = Math.max(v[0], x-v[1]);
            v[1] = x;
        }
        v[0] = Math.max(v[0], M-v[1]);
        while(!yPos.isEmpty()) {
            int y = yPos.poll();
            v[2] = Math.max(v[2], y-v[3]);
            v[3] = y;
        }
        v[2]= Math.max(v[2], N-v[3]);

        System.out.println(v[0]*v[2]);
    }
}
