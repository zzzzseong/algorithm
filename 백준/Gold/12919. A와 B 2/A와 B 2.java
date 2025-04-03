import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= word1의 길이 <= 49
        // 2 <= word2의 길이 <= 50
        // word1의 길이 < word2의 길이

        // operation1. 문자열 뒤에 A를 추가
        // operation2. 문자열 뒤에 B를 추가하고 문자열을 뒤집기

        //word1을 word2로 만들 수 있다면 1을 출력, 그렇지 않다면 0을 출력

        String word1 = br.readLine();
        String word2  = br.readLine();

        traverse(word2, word1, word2.length(), word1.length());

        System.out.println(answer);
    }

    public static void traverse(String word, String target, int wl, int tl) {
        if(word.equals(target)) answer = 1;
        if(wl < tl || answer == 1) return;

        char first = word.charAt(0);
        char last = word.charAt(wl-1);

        if(first == 'B') {
            traverse(new StringBuilder(word.substring(1)).reverse().toString(), target, wl-1, tl);
        }
        if(last == 'A') {
            traverse(word.substring(0, wl-1), target, wl-1, tl);
        }
    }
}