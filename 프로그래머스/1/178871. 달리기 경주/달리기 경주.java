import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            swapPlayer(players, map.get(callings[i]));
        }
        
        return players;
    }
    
    public void swapPlayer(String[] players, int i) {
        map.put(players[i-1], i);
        map.put(players[i], i-1);
        
        String tmp = players[i];
        players[i] = players[i-1];
        players[i-1] = tmp;
    }
}