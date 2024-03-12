import java.util.*;

class Solution {
    private List<HashSet<Long>> bucket = new ArrayList<>();

    public int solution(int N, int number) {
        bucket.add(null);

        if(N == number) return 1; 
        bucket.add(new HashSet<>());
        bucket.get(1).add((long) N);

        for (int i = 2; i <= 8; i++) {
            bucket.add(new HashSet<>());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }
            bucket.get(i).add(Long.parseLong(sb.toString()));

            for (int j = 1; j < i; j++) {
                for (Long k : bucket.get(j)) {
                    for (Long l : bucket.get(i-j)) {
                        bucket.get(i).add(k + l);
                        bucket.get(i).add(k - l);
                        bucket.get(i).add(k * l);
                        if(l != 0) bucket.get(i).add(k / l);
                    }
                }
            }

            if(bucket.get(i).contains((long) number)) return i;
        }

        return -1;
    }
}