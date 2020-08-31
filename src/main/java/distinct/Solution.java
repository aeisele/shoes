package distinct;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }

        return count;
    }

}
