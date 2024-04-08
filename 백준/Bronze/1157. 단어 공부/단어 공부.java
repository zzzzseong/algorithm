import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.toLowerCase();

        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c-'a']++;
        }

        boolean isDuplicate = false;
        int max = a[0];
        int idx = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
                idx = i;
                isDuplicate = false;
                continue;
            }

            if(a[i] == max) isDuplicate = true;
        }

        if (isDuplicate) System.out.println("?");
        else System.out.println(String.valueOf((char)('a'+idx)).toUpperCase());
    }
}