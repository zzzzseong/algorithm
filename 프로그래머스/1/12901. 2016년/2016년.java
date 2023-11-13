class Solution {
    public String solution(int a, int b) {
        int[] calender = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int day = 0;
        for(int i=1; i<a; i++) {
            day += calender[i];
        }
        day += b-1;
            
        return days[day % 7];
    }
}