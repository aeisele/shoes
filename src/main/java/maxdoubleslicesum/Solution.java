package maxdoubleslicesum;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {

        int[] maxEndingHere = new int[A.length];
        for (int i = 1; i < A.length - 2; i++) {
            maxEndingHere[i] = Math.max(0, A[i] + maxEndingHere[i - 1]);
        }

        int[] maxBeginningHere = new int[A.length];
        for (int j = A.length - 2; j > 1; j--) {
            maxBeginningHere[j] = Math.max(0, A[j] + maxBeginningHere[j + 1]);
        }

        System.out.println("max ending here" + Arrays.toString(maxEndingHere));
        System.out.println("max beginning here" + Arrays.toString(maxBeginningHere));

        // x          y          z
        // | slice 1 | | slice 2 |
        int maxDoubleSlice = 0;
        for (int k = 0; k < A.length - 2; k++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[k] + maxBeginningHere[k + 2]);
        }

        return maxDoubleSlice;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2});
        System.out.println(solution);
    }

}
