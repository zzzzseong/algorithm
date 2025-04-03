import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2  = br.readLine();

        traverse(word2, word1, word2.length(), word1.length());

        System.out.println(answer);
    }

    /**
     * @param word 현재 문자열
     * @param target 목표 문자열
     * @param wl 현재 문자열 길이
     * @param tl 목표 문자열 길이
     * */
    public static void traverse(String word, String target, int wl, int tl) {
        if(word.equals(target)) answer = 1;
        if(wl < tl || answer == 1) return;

        char head = word.charAt(0);
        char tail = word.charAt(wl-1);

        if(head == 'B') traverse(new StringBuilder(word.substring(1)).reverse().toString(), target, wl-1, tl);
        if(tail == 'A') traverse(word.substring(0, wl-1), target, wl-1, tl);
    }
}