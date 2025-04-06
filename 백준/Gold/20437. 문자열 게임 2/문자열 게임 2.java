import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if(k == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int[] answer = getMinMaxLen(str, k);

            if(answer == null) sb.append("-1").append("\n");
            else sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] getMinMaxLen(String str, int k) {
        int[] ac = new int[26];

        char[] cArr = str.toCharArray();
        for (char c : cArr) ac[c-'a']++;

        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            if(ac[i] < k) continue;

            int left = 0, right = 0, kCnt = 0;
            while(left < cArr.length && right < cArr.length) {
                while(left < cArr.length) {
                    if(cArr[left] == 'a'+i) {
                        kCnt++;
                        break;
                    }
                    else left++;
                }

                right = left+1;

                while(right < cArr.length && kCnt < k) {
                    if(cArr[right] == 'a'+i) kCnt++;
                    right++;
                }

                if(kCnt == k) {
                    int len = right-left;
                    answer[0] = Math.min(answer[0], len);
                    answer[1] = Math.max(answer[1], len);
                }

                left++;
                kCnt = 0;
            }
        }

        if(answer[0] == Integer.MAX_VALUE && answer[1] == Integer.MIN_VALUE) return null;
        else return answer;
    }
}