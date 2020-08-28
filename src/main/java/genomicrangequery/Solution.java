package genomicrangequery;

import java.util.Arrays;

public class Solution {

    public int[] solution(String S, int[] P, int[] Q) {

        int[] sumsA = new int[S.length() + 1];
        int[] sumsC = new int[S.length() + 1];
        int[] sumsG = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {

            sumsA[i + 1] = sumsA[i];
            sumsC[i + 1] = sumsC[i];
            sumsG[i + 1] = sumsG[i];

            char nucleo = S.charAt(i);
            switch (nucleo) {
                case 'A':
                    sumsA[i + 1]++;
                    break;
                case 'C':
                    sumsC[i + 1]++;
                    break;
                case 'G':
                    sumsG[i + 1]++;
                    break;
                case 'T':
                    // doesn't matter
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + nucleo);
            }
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            boolean aInRange = sumsA[Q[i] + 1] - sumsA[P[i]] > 0;
            boolean cInRange = sumsC[Q[i] + 1] - sumsC[P[i]] > 0;
            boolean gInRange = sumsG[Q[i] + 1] - sumsG[P[i]] > 0;
            if (aInRange) {
                result[i] = 1;
            } else if (cInRange) {
                result[i] = 2;
            } else if (gInRange) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] solution = new Solution().solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        System.out.println(Arrays.toString(solution));
    }

}
