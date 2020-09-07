package triangle;


import java.util.Arrays;

// triangular is:
// A + B > C
// A + C > B
// B + C > A
// after sorting we know:
// A + C > B
// B + C > A
// -> only need to check:
// A + B > C
public class Solution {

    public int solution(int[] A) {

        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] >= 0 && (long) A[i] + (long) A[i + 1] > A[i + 2]) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{10, 2, 5, 1, 8, 20});
        System.out.println(solution);

        final int solution2 = new Solution().solution(new int[]{10, 50, 5, 1});
        System.out.println(solution2);

        final int solution3 = new Solution().solution(new int[]{5, 3, 3});
        System.out.println(solution3);

        final int solution4 = new Solution().solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
        System.out.println(solution4);
    }

}
