package countdiv;

// better solution for people who know maths
public class Solution2 {

    public int solution(int A, int B, int K) {
        if (A % K == 0) {
            return (B - A) / K + 1;
        }
        return (B - (A - A % K)) / K;
    }

    public static void main(String[] args) {
        //int solution = new Solution2().solution(6, 11, 2);
        int solution = new Solution().solution(11, 345, 17);
        System.out.println(solution);
    }

}
