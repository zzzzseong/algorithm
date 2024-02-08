import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //1, 1, 1, 2
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(1L);
        list.add(1L);
        list.add(2L);
        list.add(2L);

        for(int i=5; i<=100; i++) {
            list.add(list.get(i-5) + list.get(i-1));
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(list.get(n-1)).append("\n");
        }

        System.out.println(sb);
    }
}