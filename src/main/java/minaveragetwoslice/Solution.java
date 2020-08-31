package minaveragetwoslice;

public class Solution {

    // Sheng says: "minium average slice must consist of 2 or 3 elements as larger ones can be split to that"
    public int solution(int[] A) {
        double minAvg = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < A.length - 2; i++) {
            // 2 slice
            double avg = (A[i] + A[i + 1]) / 2.0;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i;
            }

            // 3 slice
            avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i;
            }
        }

        // last 2 slice
        double avg = (A[A.length - 2] + A[A.length - 1]) / 2.0;
        if (minAvg > avg) {
            minIndex = A.length - 2;
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{-18, 65, -11, 73, -22, 90, 21, 10, 47, 87});
        System.out.println(solution);
    }

}
