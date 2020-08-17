package oddoccurances;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        Arrays.sort(A);

        int i;
        for (i = 0; i < A.length - 1 && A[i] == A[i + 1]; i+=2);

        return A[i];
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{42});
        System.out.println(solution);
    }

}


