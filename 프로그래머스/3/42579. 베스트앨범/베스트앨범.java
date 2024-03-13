import java.util.*;

class Solution {
    
    private Map<String, Integer> total = new HashMap<>();
    private Map<String, PriorityQueue<Song>> song = new HashMap<>();
    
    public void init(String[] genres, int[] plays) {
        
        for(int i=0; i<genres.length; i++) {
            if(total.get(genres[i]) == null) {
                total.put(genres[i], 0);
                song.put(genres[i], new PriorityQueue<>());
            }
            
            total.put(genres[i], total.get(genres[i])+plays[i]);
            song.get(genres[i]).offer(new Song(i, plays[i]));
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        init(genres, plays);
        
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int t1 = total.get(o1);
            int t2 = total.get(o2);
            
            return t2-t1;
        });
        
        for(String key : total.keySet()) {
            pq.offer(key);
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!pq.isEmpty()) {
            String genre = pq.poll();
            
            PriorityQueue<Song> q = song.get(genre);
            
            int count = 0;
            while(!q.isEmpty() && count < 2) {
                answer.add(q.poll().getIndex());
                count++;
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    
}

class Song implements Comparable<Song> {
    
    private int index;
    private int play;
    
    public Song(int index, int play) {
        this.index = index;
        this.play = play;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public int compareTo(Song s) {
        return s.play-this.play;
    }
}