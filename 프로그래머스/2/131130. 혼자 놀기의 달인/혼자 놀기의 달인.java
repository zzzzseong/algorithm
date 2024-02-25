import java.util.*;

class Solution {
    int[] parents;

    public int solution(int[] cards) {
        int answer = 0;

        parents = cards;
        int n = cards.length;

        Map<Integer, Integer> counts = new HashMap<>();

        for(int i=0; i<n; i++){
            parents[i]--;
        }

        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            int num = 0;
            if(!visited[i]){
                num = find(i, visited);
            }else{
                num = parents[i];
            }

            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        if(counts.size() < 2){
            answer = 0;
        }else{
            List<Integer> vals = new ArrayList<>();
            for(int v : counts.values()){
                vals.add(v);
            }

            vals.sort((o1, o2) -> o2-o1);

            answer = (vals.get(0) * vals.get(1));
        }

        return answer;
    }


    int find(int a, boolean[] visited){
        if(a == parents[a] || visited[a]){
            return a;
        }
        visited[a] = true;
        
        // find연산을 하되, 최상위 부모를 저장하도록 함
        return parents[a] = find(parents[a], visited);
    }
}