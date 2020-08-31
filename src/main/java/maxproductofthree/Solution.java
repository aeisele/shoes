package maxproductofthree;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {

        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        Arrays.sort(A);

        int[] candidates;
        if (A.length == 4) {
            candidates = A;
        } else {
            candidates = new int[]{A[0], A[1], A[A.length - 3], A[A.length - 2], A[A.length - 1]};
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < candidates.length; i++) {
            for (int j = i + 1; j < candidates.length; j++) {
                for (int k = j + 1; k < candidates.length; k++) {
                    int sum = candidates[i] * candidates[j] * candidates[k];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{-3, 1, 2, -2, 5, 6});
        //int solution = new Solution().solution(new int[]{-5, 5, -5, 4});
        System.out.println(solution);
    }

}
