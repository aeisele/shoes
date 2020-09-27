package equileader;

public class Solution {

    // leader = count(x) > n / 2
    // we want to split the array in 2 parts
    // -> only the leader can be the equi leader
    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int size = 0;
        Integer value = null;
        for (int i : A) {
            if (value == null || size == 0) {
                value = i;
                size++;
            } else if (i != value) {
                size--;
            } else {
                size++;
            }
        }

        Integer leader = null;
        int count = 0;
        if (size > 0) {
            for (int j : A) {
                if (j == value) {
                    count++;
                }
            }

            if (count > A.length / 2) {
                leader = value;
            }
        }

        if (leader == null) {
            return 0;
        }

        int countLeft = 0;
        int countRight = count;
        int equiCount = 0;
        for (int k = 0; k < A.length - 1; k++) {
            if (A[k] == leader) {
                countLeft++;
                countRight--;
            }
            // S need not be the leader, we can split at irrelevant value and still have equi condition
            if ((countLeft > (k + 1) / 2)
                && (countRight > (A.length - 1 - k) / 2)) {
                equiCount++;
            }
        }

        return equiCount;
    }

    public static void main(String[] args) {
        //final int solution = new Solution().solution(new int[]{4, 3, 4, 4, 4, 2});
        // 2 (0, 2)
        final int solution = new Solution().solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4});
        // 3
        System.out.println(solution);
    }

}
