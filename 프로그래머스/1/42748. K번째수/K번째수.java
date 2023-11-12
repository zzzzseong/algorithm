import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;

        for(int[] command : commands) {
            int[] arr = Arrays.copyOfRange(array, command[0]-1, command[1]);

            for(int i=1; i<arr.length; i++) {
                for(int j=0; j<arr.length-1; j++) {
                    if(arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }

            answer[count] = arr[command[2]-1];
            count++;
        }

        return answer;
    }
}