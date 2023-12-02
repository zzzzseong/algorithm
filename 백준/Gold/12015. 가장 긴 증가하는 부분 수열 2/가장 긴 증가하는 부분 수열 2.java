import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*BAEKJOON */
public class Main {
    private static int[] sequence;
    private static List<Integer> bucket = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }

        bucket.add(sequence[0]);
    }

    public static void main(String[] args) throws IOException {
        init();

        int head = 0;
        for (int i = 1; i < sequence.length; i++) {
            if(sequence[i] > bucket.get(head)) {
                bucket.add(sequence[i]);
                head++;
            } else {
                swap(0, head, sequence[i]);
            }
        }

        System.out.println(bucket.size());
    }

    public static void swap(int sIdx, int eIdx, int target) {
        if(sIdx == eIdx) {
            bucket.set(sIdx, target);
            return;
        }

        int mIdx = (sIdx + eIdx) / 2;
        if(target > bucket.get(mIdx)) swap(mIdx+1, eIdx, target);
        if(target == bucket.get(mIdx)) return;
        if(target < bucket.get(mIdx)) swap(sIdx, mIdx, target);
    }
}