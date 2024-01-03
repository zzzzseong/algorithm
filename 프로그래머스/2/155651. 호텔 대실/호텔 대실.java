import java.util.*;

class Solution {
    private int[][] book;
    
    public void init(String[][] book_time) {
        book = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++) {
            String[] sTime = book_time[i][0].split(":");
            String[] eTime = book_time[i][1].split(":");
            
            book[i][0] = Integer.parseInt(sTime[0])*60 + Integer.parseInt(sTime[1]);
            book[i][1] = Integer.parseInt(eTime[0])*60 + Integer.parseInt(eTime[1]);
        }
    }
    
    public int solution(String[][] book_time) {
        init(book_time);
        
        //sTime 기준 오름차순 정렬
        Arrays.sort(book, (b1, b2) -> b1[0] - b2[0]);
        
        List<Integer> schedule = new ArrayList<>();
        schedule.add(book[0][1]);
        
        for(int i=1; i<book.length; i++) {
            
            boolean canBook = false;
            for(int j=0; j<schedule.size(); j++) {
                if(schedule.get(j) + 10 <= book[i][0]) {
                    schedule.set(j, book[i][1]); 
                    canBook = true;
                    break;
                }
            }
            
            if(!canBook) {
                schedule.add(book[i][1]);
            }
        }
        
        return schedule.size();
    }
}