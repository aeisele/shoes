package numberofdiscintersections;

import java.util.Arrays;

public class Solution {
    //       0
    // 0    ---
    // 1  ----------
    // 2     ----
    // 3       --
    // 4     --------
    // 5          ()
    // 6                 ----
    // sort() (beginning)
    // 1  ----------
    // 0    ---
    // 2     ----
    // 4     --------
    // 3       --
    // 5          ()
    // 6                 ----
    // sort() (end)
    // 0    ---
    // 2     ----
    // 3       --
    // 1  ----------
    // 5          ()
    // 4     --------
    // 6                 ----
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int discs = A.length;
        long[] starts = new long[discs];
        long[] ends = new long[discs];
        for (int i = 0; i < discs; i++) {
            starts[i] = (long) i - (long) A[i];
            ends[i] = (long) i + (long) A[i];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int intersections = 0;
        int left = 0;
        for (int right = 0; right < discs; right++) {
            while (left < discs && ends[right] >= starts[left]) {
                left++;
            }
            // left     <-  count of discs that start before our end
            // - right  <-  count of discs that already ended
            // - 1      <-  intersection with itself
            intersections += left - right - 1;
            if (intersections > 10_000_000) {
                return -1;
            }
        }

        return intersections;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{1, 5, 2, 1, 4, 0});
        System.out.println(solution);
    }


}
