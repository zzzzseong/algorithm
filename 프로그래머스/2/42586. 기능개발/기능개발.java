import java.util.*;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progList = new ArrayList<>();
        List<Integer> speedList = new ArrayList<>();
        for (int progress : progresses) {
            progList.add(progress);
        }
        for (int speed : speeds) {
            speedList.add(speed);
        }

        List<Integer> releaseList = new ArrayList<>();

        while(!progList.isEmpty()) {
            int count = 0;
            int loopSize = progList.size();
            for (int i = 0; i < loopSize; i++) {
                if(progList.get(0) < 100) break;
                progList.remove(0);
                speedList.remove(0);
                count++;
            }

            if(count != 0) releaseList.add(count);
            for (int i = 0; i < progList.size(); i++) { //element update
                progList.set(i, progList.get(i) + speedList.get(i));
            }
        }

        int[] answer = new int[releaseList.size()];
        for (int i = 0; i < releaseList.size(); i++) {
            answer[i] = releaseList.get(i);
        }
        return answer;
        }
}