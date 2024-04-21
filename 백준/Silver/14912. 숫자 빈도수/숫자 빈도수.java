import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int d = Integer.parseInt(line[1]);

        int answer = 0;
        for (int num = 1; num <= n; num++) {
            answer += getCnt(num, d);
        }

        System.out.println(answer);
    }

    public static int getCnt(int num, int d) {
        int cnt = 0;
        while(num > 0) {
            if(num%10 == d) cnt++;
            num /= 10;
        }
        return cnt;
    }
}