import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            String[] op = operations[i].split(" ");
            
            int num = Integer.parseInt(op[1]);
            
            if("I".equals(op[0])) {
                minHeap.offer(num);
                maxHeap.offer(num);
                continue;
            }
            if(!minHeap.isEmpty()) {
                if("D".equals(op[0]) && num == 1) {
                minHeap.remove(maxHeap.poll());
            }
                if("D".equals(op[0]) && num == -1) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if(minHeap.isEmpty()) {
            return new int[]{0, 0};
        }
        if(minHeap.size() == 1) {
            int n = minHeap.poll();
            return new int[]{n, n};
        }
        
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}