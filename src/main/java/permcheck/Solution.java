package permcheck;

public class Solution {

    public int solution(int[] A) {
        int n = A.length;

        boolean[] existing = new boolean[n + 1];

        for (int i : A) {
            if (i > n) {
                return 0;
            }

            if (existing[i]) {
                return 0;
            }

            existing[i] = true;
        }

        for (int j = 1; j < existing.length; j++) {
            if (!existing[j]) {
                return 0;
            }
        }

        return 1;
    }

}
