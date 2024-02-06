import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int answer = 0;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); //카드 갯수
        M = Integer.parseInt(line[1]); //목표값

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] vis = new boolean[cards.length];

        comb(cards, vis, 0, 3, 0);

        System.out.println(answer);
    }

    public static void comb(int[] cards, boolean[] vis, int sIdx, int r, int v) {
        if(r == 0) {
            if(v <= M) {
                answer = Math.max(answer, v);
            }
            return;
        }

        for (int i = sIdx; i < cards.length; i++) {
            if(vis[i]) continue;

            vis[i] = true;
            comb(cards, vis, i+1, r-1, v+cards[i]);
            vis[i] = false;
        }


    }
}