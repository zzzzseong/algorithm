import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<String, int[]> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            String s = survey[i];
            if(s.equals("TR") || s.equals("FC") || s.equals("MJ") || s.equals("NA")) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(1)).append(s.charAt(0));
                s = sb.toString();
                choices[i] = Math.abs(8-choices[i]);
            }
            if(map.get(s) == null) map.put(s, new int[2]);
                        
            int choice = choices[i];
            int[] score = map.get(s);
            if(choice < 4) score[0] += (choice == 2) ? 2 : Math.abs(4-choice);
            if(choice > 4) score[1] += choice-4;
        }
        
        String[] type = {"RT", "CF", "JM" ,"AN"};
        for(int i=0; i<type.length; i++) {
            int[] AB = map.get(type[i]);
            
            if(AB == null) answer += type[i].charAt(0);
            else answer += (AB[0] >= AB[1]) ? type[i].charAt(0) : type[i].charAt(1);
        }
        
        return answer;
    }
}