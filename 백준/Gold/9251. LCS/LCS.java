import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[] seq1, seq2;
    private static int len1, len2;

    private static int[][] dp;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seq1 = br.readLine().toCharArray();
        seq2 = br.readLine().toCharArray();
        len1 = seq1.length;
        len2 = seq2.length;

        dp = new int[len1+1][len2+1];
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(seq1[i-1] == seq2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        System.out.println(dp[len1][len2]);
    }
}