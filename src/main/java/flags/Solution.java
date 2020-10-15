package flags;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {

        if (A.length < 3) {
            return 0;
        }

        int[] nextPeak = new int[A.length];
        Arrays.fill(nextPeak, -1);

        int peakCount = 0;
        int firstPeak = -1;

        for (int i = A.length - 2; i > 0; i--) {
            if (A[i] > A[i + 1] && A[i] > A[i - 1]) {
                nextPeak[i] = i;
                peakCount++;
                firstPeak = i;
            } else {
                nextPeak[i] = nextPeak[i + 1];
            }
        }

        if (peakCount <= 1) {
            return peakCount;
        }

        int maxFlags = 1;

        // todo: this is cool upper bound but why?
        int maxDistance = (int) Math.sqrt(A.length);
        for (int k = maxDistance + 1; k > 1; k--) {
            int flags = 1;
            int flagsLeft = k - 1;
            int position = firstPeak;
            while (flagsLeft > 0) {
                if (position + k >= A.length - 1) {
                    // beyond array bounds
                    break;
                }
                position = nextPeak[position + k];
                if (position == -1) {
                    // no next peak
                    break;
                }
                flags++;
                flagsLeft--;
            }
            maxFlags = Math.max(maxFlags, flags);
        }

        return maxFlags;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
        System.out.println(solution);
    }

}
