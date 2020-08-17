package permmissingelement;

/*
 [1, 2, 3, 4, 5] = 15

*/

public class Solution {

    public int solution(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum ^ A[i] ^ (i + 1);
        }
        return sum ^ (A.length + 1);
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{2, 3, 1, 5});
        System.out.println(solution);
    }

}
