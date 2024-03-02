import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        
        BigInteger newA = new BigInteger(a);
        BigInteger newB = new BigInteger(b);
        
        return newA.add(newB).toString();
    }
}