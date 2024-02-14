import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        //500_000
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            String card = st.nextToken();

            map.putIfAbsent(card, 0);
            map.put(card, map.get(card)+1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] answer = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            String target = st2.nextToken();

            if(map.get(target) == null) {
                answer[i] = 0;
            } else {
                answer[i] = map.get(target);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
//            System.out.print(answer[i] + " ");
        }

        System.out.println(sb);

    }
}