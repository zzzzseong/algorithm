class Solution {
    private int answer = 0;
    
    public int solution(int[] nums) {        
        combination(nums, 0, 3, 0);
        return answer;
    }
    
    public void combination(int[] nums, int sIdx, int r, int sum) {
        if(r == 0) {
            if(isPrime(sum)) answer++;
            return;
        }
        
        for(int i=sIdx; i<nums.length; i++) {
            combination(nums, i+1, r-1, sum+nums[i]);
        }
    }
    
    public boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for(int i=2; i<=sqrt; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}