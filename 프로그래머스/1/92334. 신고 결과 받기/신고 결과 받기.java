import java.util.*;

class Solution {
    public void init(Map<String, Set<String>> map, Map<String, Integer> record, String[] id_list, String[] reports) {
        //1000
        for(String username : id_list) {
            map.put(username, new HashSet<>());
            record.put(username, 0);
        }
        //200_000
        for(String report : reports) {
            String[] r = report.split(" ");
            map.get(r[0]).add(r[1]);
        }
        
        //200_000 * log(200_000)
        for(int i=0; i<id_list.length; i++) {
            String username = id_list[i];
            Set<String> set = map.get(username);
            
            for(String report : set) {
                record.put(report, record.get(report) + 1);
            }
        }
    }
    
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> record = new HashMap<>();
        init(map, record, id_list, reports);
        
        //200_000 * log(200_000)
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            String username = id_list[i];
            Set<String> set = map.get(username);
            for(String report : set) {
                if(record.get(report) >= k) answer[i]++;
            }
        }

        return answer;
    }
}