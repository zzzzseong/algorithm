import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] splitToday = today.split("\\.");
        /**
         * [0]: yyyy / [1]: mm / [2]: dd
         */
        Map<String, String> tMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            tMap.put(s[0], s[1]);
        }

        List<Integer> destroy = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            String[] splitPrivacies = s[0].split("\\.");
            int y = Integer.parseInt(splitToday[0]) - Integer.parseInt(splitPrivacies[0]);
            int m = Integer.parseInt(splitToday[1]) - Integer.parseInt(splitPrivacies[1]);
            if(m < 0) {
                y--;
                m += 12;
            }
            m += y*12;
            int d = Integer.parseInt(splitToday[2]) - Integer.parseInt(splitPrivacies[2]);
            if(d < 0) {
                m--;
                d += 28;
            }

            if(m >= Integer.parseInt(tMap.get(s[1]))) {
                destroy.add(i + 1);
            }
        }

        int[] answer = new int[destroy.size()];
        for (int i = 0; i < destroy.size(); i++) {
            answer[i] = destroy.get(i);
        }
        return answer;
    }
}