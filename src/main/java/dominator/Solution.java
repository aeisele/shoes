package dominator;

public class Solution {

    public int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        // emulate a stack without using the stack as we are not interested in more than one value
        Integer value = null;
        int size = 0;
        for (int i : A) {
            if (value == null) {
                value = i;
                size++;
            } else if (i != value) {
                size--;
                if (size == 0) {
                    value = null;
                }
            } else {
                size++;
            }
        }

        int count = 0;
        int index = -1;
        if (size > 0) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == value) {
                    count++;
                    index = i;
                }
            }
            if (count > A.length / 2) {
                return index;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        //final int solution = new Solution().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});
        // 0, 2, 4, 6, 7
        final int solution = new Solution().solution(new int[]{1, 2, 1});
        System.out.println(solution);
    }

}
