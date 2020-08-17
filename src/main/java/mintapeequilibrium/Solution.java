package mintapeequilibrium;

public class Solution {

    public int solution(int[] A) {
        int headSum = A[0];
        int tailSum = 0;
        for (int i = 1; i < A.length; i++) {
            tailSum += A[i];
        }

        int minDiff = Math.abs(headSum - tailSum);

        for (int p = 2; p < A.length; p++) {
            headSum += A[p - 1];
            tailSum -= A[p - 1];
            int diff = Math.abs(headSum - tailSum);
            if (minDiff > diff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(solution);
    }

}
