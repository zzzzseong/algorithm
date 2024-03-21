class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
                        
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String a1 = Integer.toString(arr1[i], 2);
            String a2 = Integer.toString(arr2[i], 2);
            
            if(a1.length() < n) a1 = "0".repeat(n-a1.length()) + a1;
            if(a2.length() < n) a2 = "0".repeat(n-a2.length()) + a2;
            
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(a1.charAt(j) != '1' && a2.charAt(j) != '1') {
                    sb.append(" ");
                    continue;
                }
                
                sb.append("#");
            }
            
            answer[i] = sb.toString();
        }
        
        
        return answer;
    }
}