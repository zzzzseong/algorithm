import java.util.*;

class Solution {
private List<int[]> list = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {

        float[] dcPercent = new float[emoticons.length];
        dfs(users, emoticons, 0, dcPercent);

        Collections.sort(list, (a,b)-> b[0]-a[0] == 0 ? b[1]-a[1] : b[0]-a[0]);
        return list.get(0);
    }

    public void dfs(int[][] users, int[] emoticons, int depth, float[] dcPercent) {
        if(emoticons.length == depth) {
            list.add(result(users, emoticons, dcPercent));
            return;
        }

        for (int i = 0; i < 4; i++) {
            dcPercent[depth] = 10*(i+1);
            dfs(users, emoticons, depth+1, Arrays.copyOf(dcPercent, dcPercent.length));
        }
    }

    public int[] result(int[][] users, int[] emoticons, float[] dcPercent) {
        int[] result = new int[2];

        for (int j = 0; j < users.length; j++) {
            int totalPrice = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (users[j][0] <= dcPercent[i]) {
                    totalPrice += emoticons[i] * (1 - dcPercent[i]/100);;
                }
            }
            if(totalPrice >= users[j][1]) result[0]++;
            else result[1] += totalPrice;
        }

        return result;
    }
}