import java.util.*;

class Solution {
    private List<Integer> answer = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int time = 0;
        int index = 0;
        while(index < progresses.length) {
            time++;
            
            if((progresses[index] + speeds[index]*time) >= 100) {
                index++;                
                int count = 1;
                while(true) {
                    if(index == progresses.length) {
                        answer.add(count);
                        break;
                    }
                    
                    if(progresses[index] + speeds[index]*time >= 100) {
                        count++;
                        index++;
                    } else {
                        answer.add(count);
                        break;
                    }
                }
            }
        }
    
        int[] arr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
}