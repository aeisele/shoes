package maxslicesum;

public class Solution {

    public int solution(int[] A) {
        int maxSliceEndingHere = A[0];
        int maxSlice = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSliceEndingHere = Math.max(A[i], maxSliceEndingHere + A[i]);
            maxSlice = Math.max(maxSlice, maxSliceEndingHere);
        }
        return maxSlice;
    }

    public static void main(String[] args) {
        //final int solution = new Solution().solution(new int[]{3, 2, -6, 4, 0});
        final int solution = new Solution().solution(new int[]{-10});
        System.out.println(solution);
    }

}
