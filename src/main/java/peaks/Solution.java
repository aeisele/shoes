package peaks;

public class Solution {

    public int solution(int[] A) {

        final int n = A.length;

        boolean[] peaks = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            peaks[i] = A[i] > A[i - 1] && A[i] > A[i + 1];
        }

        int maxBlocks = 0;
        final double squareRoot = Math.sqrt(n);
        for (int k = 1; k <= squareRoot; k++) {
            if (n % k == 0) {
                if (checkBlocks(peaks, n, k)) {
                    maxBlocks = Math.max(maxBlocks, k);
                }
                int inverse = n / k;
                if (checkBlocks(peaks, n, inverse)) {
                    maxBlocks = Math.max(maxBlocks, inverse);
                }
            }
        }

        return maxBlocks;
    }

    private boolean checkBlocks(boolean[] peaks, int n, int k) {
        int step = n / k;
        for (int index = 0; index < n; index += step) {
            if (!hasPeaks(peaks, index, index + step)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasPeaks(boolean[] peaks, int start, int end) {
        for (int j = start; j < end; j++) {
            if (peaks[j]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
        System.out.println(solution);
    }

}
