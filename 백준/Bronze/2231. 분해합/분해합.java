import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = N;
        for (int i = N; i >= 0; i--) {
            int num = i;

            int m = 1;
            int sum = num;
            for (int j = 0; j < String.valueOf(num).length(); j++) {
                int a = num % (m*10);

                int b = a/m;

                sum += b;
                num -= b;
                m *= 10;
            }

            if(sum == N) {
                min = Math.min(min, i);
            }
        }

        if (min == N) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}