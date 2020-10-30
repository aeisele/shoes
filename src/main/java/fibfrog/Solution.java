package fibfrog;

// from: https://codesays.com/2014/solution-to-fib-frog-by-codility/
// todo: this can't be understood
public class Solution {

    public int solution(int[] A) {
        int n = A.length;

        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[n + 1] = -1;

        for (int i = 1; i < n + 2; i++) {
            int step = 1;
            int previous = 1;
            int min = Integer.MAX_VALUE;
            while (step <= i) {
                if ((i == n + 1 || A[i - 1] == 1)
                        && (i - step - 1 == -1 || A[i - step - 1] == 1)
                        && (dp[i - step] > 0)) {
                    min = Math.min(min, dp[i - step] + 1);
                }
                int tmp = step;
                step = step + previous;
                previous = tmp;
            }
            if (min < Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }
        return dp[n + 1] == -1 ? -1 : dp[n + 1] -1;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0});
        // 3 (5 -> 2 -> 5)
        System.out.println(solution);
    }

}
