package minperimeterrectangle;

public class Solution {

    public int solution(int N) {
        if (N == 1) {
            return 4;
        }

        int minPerimeter = 2 * (1 + N);
        final double squareRoot = Math.sqrt(N);
        for (int i = 2; i <= squareRoot; i++) {
            if (N % i == 0) {
                int inverse = N / i;
                int perimeter = 2 * (i + inverse);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(30);
        System.out.println(solution);
    }

}
