package countfactors;

public class Solution {

    public int solution(int N) {
        if (N <= 1) {
            return 1;
        }

        int count = 0;
        double root = Math.sqrt(N);
        for (int i = 1; i <= root; i++) {
            if (N % i == 0) {
                count += 2; // divisor and its inverse e.g. 4 * 6 = 24 -> 2 divisors
            }
        }

        if (N % root == 0) {
            count -= 1; // divisor is also its inverse so only 1 occurrence
        }

        return count;
    }

    public static void main(String[] args) {
        //final int solution = new Solution().solution(24);
        //final int solution = new Solution().solution(16);
        final int solution = new Solution().solution(Integer.MAX_VALUE);
        System.out.println(solution);
    }

}
