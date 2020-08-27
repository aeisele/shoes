package maxcounters;

import java.util.Arrays;

public class Solution {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int maxCounter = 0;

        for (int op : A) {
            if (op == N + 1) {
                maxCounter = max;
            } else {
                if (counters[op - 1] < maxCounter) {
                    counters[op - 1] = maxCounter;
                }
                counters[op - 1]++;
                if (counters[op - 1] > max) {
                    max = counters[op - 1];
                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < maxCounter) {
                counters[i] = maxCounter;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        int[] solution = new Solution().solution(5, new int[]{3, 4, 4, 6, 6, 6, 1, 4, 4});
        System.out.println(Arrays.toString(solution));
    }

}
