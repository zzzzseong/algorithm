import java.util.Arrays;

class Solution {
    public boolean solution(int x) {        
        int div = sum(x);
        if(x % div == 0) return true;
        else return false;
    }
    
    public int sum(int x) {
        String[] arr = Integer.toString(x).split("");
        return Arrays.stream(arr).mapToInt(Integer::parseInt).sum();
    }
}