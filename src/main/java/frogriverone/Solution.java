package frogriverone;

class Solution {
    public int solution(int X, int[] A) {

        if (X == 0) {
            return -1;
        }

        int leafCount = 0;
        int[] leaves = new int[X + 1];
        for (int i = 0; i < A.length; i++) {
            int fallPosition = A[i];
            if (leaves[fallPosition] == 0) {
                leafCount++;
            }
            leaves[fallPosition]++;

            if (leafCount == X) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(solution);
    }
}
