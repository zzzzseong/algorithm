import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] hw = br.readLine().split(" ");
        int w = Integer.parseInt(hw[1]);

        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;

        int min = heights[0];
        int sum = 0;
        for(int i=1; i<w; i++) {
            if(heights[i] >= min) {
                min = heights[i];
                answer += sum;
                sum = 0;
            }
            else sum += min-heights[i];
        }

        min = heights[w-1];
        sum = 0;
        for(int i=w-1; i>=0; i--) {
            if(heights[i] > min) {
                min = heights[i];
                answer += sum;
                sum = 0;
            }
            else sum += min-heights[i];
        }

        System.out.println(answer);
    }
}