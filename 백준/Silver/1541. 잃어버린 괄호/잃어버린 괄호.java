import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                operators.add(str.charAt(i));
                numbers.add(Integer.parseInt(str.substring(idx, i)));
                idx = i+1;
            }
        }

        numbers.add(Integer.parseInt(str.substring(idx)));

        List<Integer> answer = new ArrayList<>();

        int sum = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if(operators.get(i) == '+') {
                sum += numbers.get(i+1);
            } else {
                answer.add(sum);
                sum = numbers.get(i+1);
            }
        }
        answer.add(sum);

        int ans = answer.get(0);
        for (int i = 1; i < answer.size(); i++) {
            ans -= answer.get(i);
        }

        System.out.println(ans);

    }
}