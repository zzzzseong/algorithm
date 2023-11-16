class Solution {
    public int[] solution(String[] wallpaper) {        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int i=0; i<wallpaper.length; i++) {
            String row = wallpaper[i];
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                }
            }
        }
        
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=wallpaper.length-1; i>=0; i--) {
            String row = wallpaper[i];
            for(int j=row.length()-1; j>=0; j--) {
                if(row.charAt(j) == '#') {
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
     
        int[] answer = {minX, minY, maxX+1, maxY+1};
        return answer;
    }
}