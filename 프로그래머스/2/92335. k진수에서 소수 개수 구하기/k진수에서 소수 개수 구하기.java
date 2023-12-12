class Solution {
    public int solution(int n, int k) {
        String[] numbers = Integer.toString(n, k).split("0");

        int answer = 0;
        for(int i=0; i<numbers.length; i++) {
            if("".equals(numbers[i]) || "1".equals(numbers[i])) continue;
            if(isPrime(Long.parseLong(numbers[i]))) answer++;
        }
        
        return answer;
    }

    public boolean isPrime(long number) {
        double sqrt = Math.sqrt(number);
        for(int i=2; i<=sqrt; i++) {
            if(number%i == 0) return false;
        }
        
        return true;
    }
}