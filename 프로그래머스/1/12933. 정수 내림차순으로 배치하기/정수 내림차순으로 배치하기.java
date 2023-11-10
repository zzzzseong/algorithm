import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        String[] arr = str.split("");

        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[j] > nums[j-1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int num : nums) {
            answer.append(num);
        }

        return Long.parseLong(answer.toString());
    }
}