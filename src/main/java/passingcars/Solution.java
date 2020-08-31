package passingcars;

public class Solution {

    public int solution(int[] A) {
        int[] sumsWestBehind = new int[A.length + 1];
        int[] eastIndexes = new int[A.length];
        int eastCount = 0;
        for (int i = 0; i < A.length; i++) {
            int carsBehind = sumsWestBehind[i] + A[i];
            if (carsBehind > 1_000_000_000) {
                return -1;
            }
            sumsWestBehind[i + 1] = carsBehind;

            if (A[i] == 0) {
                eastIndexes[eastCount] = i;
                eastCount++;
            }
        }

        if (eastCount == 0) {
            return 0;
        }

        int sumPassing = 0;
        for (int i = 0; i < eastCount; i++) {
            int newSum = sumPassing + (sumsWestBehind[A.length] - sumsWestBehind[eastIndexes[i]]);
            if (newSum > 1_000_000_000 || newSum < 0) {
                return -1;
            }
            sumPassing = newSum;
        }

        return sumPassing;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{0, 1, 0, 1, 1});
        System.out.println(solution);
    }

}
