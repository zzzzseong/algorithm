import java.util.*;

class Solution {
    
    private Map<String, List<Go>> map = new HashMap<>();
    private PriorityQueue<String[]> pq;
    
    public void init(String[][] tickets) {
        for(int i=0; i<tickets.length; i++) {
            String s = tickets[i][0];
            String e = tickets[i][1];
            
            if(!map.containsKey(s)) map.put(s, new ArrayList<>());
            
            map.get(s).add(new Go(e));
        }
        
        pq = new PriorityQueue<>((r1, r2) -> {            
            int i;
            for(i=0; i<r1.length; i++) {
                if(!r1[i].equals(r2[i])) return r1[i].compareTo(r2[i]);
            }
            
            return 0;
        });
    }
    
    public String[] solution(String[][] tickets) {
                        
        init(tickets);
                
        String[] hist = new String[tickets.length+1];        
        hist[0] = "ICN";
        dfs(hist[0], 0, hist);
                
        return pq.poll();
    }
    
    public void dfs(String city, int depth, String[] hist) {
        if(depth >= hist.length-1) {            
            String[] result = new String[hist.length];
            for(int i=0; i<hist.length; i++) {
                result[i] = hist[i];
            }
            
            pq.offer(result);
            return;
        }
         
        if(!map.containsKey(city)) return;
        
        for(Go go : map.get(city)) {
            if(go.isVisit()) continue;
            
            go.setVisit(true);
            hist[depth+1] = go.getCity();
            dfs(go.getCity(), depth+1, hist);
            go.setVisit(false);
        }
    }
}

class Go {
    private String city;
    private boolean visit = false;
    
    public Go(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return city;
    }
    
    public boolean isVisit() {
        return visit;
    }
    
    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}