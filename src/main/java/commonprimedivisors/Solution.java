package commonprimedivisors;

public class Solution {

    public int solution(int[] A, int[] B) {
        int length = A.length;

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (hasOnlyCommonPrimeDivisors(A[i], B[i])) {
                count++;
            }
        }

        return count;
    }

    // if a and b have only common prime divisors they both
    // need to be composed of only the prime divisors in ggt
    private boolean hasOnlyCommonPrimeDivisors(int a, int b) {
        int ggt = ggt(a, b);

        int aRest = removeCommonPrimeDivisors(a, ggt);
        if (aRest != 1) {
            return false;
        }
        int bRest = removeCommonPrimeDivisors(b, ggt);
        return bRest == 1;
    }

    private int ggt(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return ggt(b, a % b);
    }

    // remove all common divisors shared between n and common and return the remainder
    private int removeCommonPrimeDivisors(int n, int common) {
        while (n != 1) {
            int ggt = ggt(n, common);
            if (ggt == 1) {
                // no more common divisors in n
                break;
            }
            n /= ggt;
        }
        return n;
    }

    public static void main(String[] args) {
        // 1
        final int solution = new Solution().solution(new int[]{15, 10, 3}, new int[]{75, 30, 5});
        System.out.println(solution);
    }

}
