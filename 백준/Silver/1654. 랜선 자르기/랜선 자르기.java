import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int K = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        long hi = Integer.MIN_VALUE;
        long lo = 0;

        int[] lan = new int[K];
        for (int i = 0; i < lan.length; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            hi = Math.max(hi, lan[i]);
        }

        hi++;

        long max = Integer.MIN_VALUE;
        while(hi > lo) {
            long mid = (lo+hi)/2;

            int sum = 0;
            for (int i = 0; i < lan.length; i++) {
                sum += lan[i]/mid;
            }

            if(sum >= N) {
                max = Math.max(max, mid);
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        System.out.println(max);

    }
}