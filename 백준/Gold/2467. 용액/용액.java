import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int left = 0, right = n-1;

        long[] answer = new long[]{nums[left], nums[right]};

        long min = Math.abs(answer[0] + answer[1]);

        while(left < right) {
            long sum = nums[left] + nums[right];
            long abs = Math.abs(nums[left] + nums[right]);

            if(abs < min) {
                min = abs;
                answer[0] = nums[left];
                answer[1] = nums[right];
            }
            
            if(sum == 0) break;
            if(sum > 0) right--;
            if(sum < 0) left++;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}