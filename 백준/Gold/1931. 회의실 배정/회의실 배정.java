import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] schedules = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] schedule = br.readLine().split(" ");
            schedules[i][0] = Integer.parseInt(schedule[0]);
            schedules[i][1] = Integer.parseInt(schedule[1]);
        }

        Arrays.sort(schedules, (s1, s2)->{
            if(s1[1]==s2[1]) return s1[0]-s2[0];
            else return s1[1]-s2[1];
        });

        int end = 0;
        for(int[] schedule : schedules) {
            if(schedule[0] >= end) {
                answer++;
                end = schedule[1];
            }
        }

        System.out.println(answer);
    }
}