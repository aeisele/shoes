package missingint;

public class Solution2 {

    public int solution(int[] A) {

        boolean[] existing = new boolean[A.length + 1];

        for (int i : A) {
            if (i > 0 && i < A.length + 1) {
                existing[i] = true;
            }
        }

        for (int j = 1; j < existing.length; j++) {
            if (!existing[j]) {
                return j;
            }
        }

        return existing.length;
    }

    public static void main(String[] args) {
        int solution = new Solution2().solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(solution);
    }

}
