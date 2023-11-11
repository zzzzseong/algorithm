class Solution {
    public long solution(int price, int money, int count) {
        long curPrice = 0;
        long answer = 0;
        
        for(int i=0; i<count; i++) {
            curPrice += price;
            answer += curPrice;
        }
        
        if(answer < money) return 0;
        else return answer - money;
    }
}