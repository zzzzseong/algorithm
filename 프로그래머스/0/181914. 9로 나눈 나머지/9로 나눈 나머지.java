import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        
        BigInteger bi = new BigInteger(number);
        
        return bi.mod(new BigInteger("9")).intValue();
    }
}