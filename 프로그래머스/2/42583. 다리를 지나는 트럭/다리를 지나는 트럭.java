import java.util.*;

class Solution {
    private Queue<Truck> bridge = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int idx = 0;
        
        bridge.offer(new Truck(time++, truck_weights[idx]));
        
        //bridge에 올라가있는 트럭의 총 무게
        int total = truck_weights[idx++];
        
        while(!bridge.isEmpty()) {
            if((time-bridge.peek().getEnter()) == bridge_length) {
                //가장 앞 트럭이 나올 수 있다면
                total -= bridge.poll().getWeight();
            }
            
            if(idx < truck_weights.length && total + truck_weights[idx] <= weight) {
                //트럭이 진입할 수 있다면
                bridge.offer(new Truck(time, truck_weights[idx]));
                total += truck_weights[idx++];
            }
            
            time++;
        }
        
        return time-1;
    }
}

class Truck {
    private int enter;
    private int weight;
    
    public Truck(int enter, int weight) {
        this.enter = enter;
        this.weight = weight;
    }
    
    public int getEnter() {
        return enter;
    }
    public int getWeight() {
        return weight;
    }
}