import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        //단어를 모두 대문자로 초기화해서 저장
        String[] words = s.toUpperCase().split(" ", -1);
        
        System.out.println(Arrays.toString(words));
        
        
        for(String word : words) {
            //2개 이상의 공백 예외처리
            if(Objects.equals(word, "")) {
                answer += " ";
                continue;
            }
            
            for(int i=0; i<word.length(); i++) {
                //짝수라면 대문자 그대로 저장
                if(i%2 == 0) answer += word.charAt(i);
                
                //홀수라면 소문자로 변경해서 저장
                else answer += (char) ('a' + (word.charAt(i) - 'A'));
            }
            answer += " ";
        }
        
        //마지막 공백을 제외한 문자열 반환
        return answer.substring(0, answer.length()-1);
    }
}

//먼저 앞, 뒤 공백을 제외하고
//안에 있는 공백은 다 살려야함
//
