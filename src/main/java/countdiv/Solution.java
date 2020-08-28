package countdiv;

public class Solution {

    public int solution(int A, int B, int K) {

        int remainder = A % K;
        int firstDiv;
        if (remainder > 0) {
            if (remainder == A && A < K) {
                firstDiv = K;
            } else {
                firstDiv = A + remainder;
            }
        } else {
            firstDiv = A;
        }

        int lastDiv;
        remainder = B % K;
        if (remainder > 0) {
            lastDiv = B - remainder;
        } else {
            lastDiv = B;
        }

        if (firstDiv > B || lastDiv < A) {
            return 0;
        }

        if (firstDiv == lastDiv) {
            return 1;
        }

        return ((lastDiv - firstDiv) / K) + 1;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(6, 11, 2);
        //int solution = new Solution().solution(11, 345, 17);
        System.out.println(solution);
    }

}
