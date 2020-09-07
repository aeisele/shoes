package fish;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int solution(int[] A, int[] B) {
        if (A.length == 1) {
            return 1;
        }

        int alive = 0;

        Deque<Integer> downStream = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                // is swimming down, can not eat all preceding
                downStream.push(A[i]);
            } else {
                // fish is swimming up, if there are downstream fish they can be eaten
                while (!downStream.isEmpty()) {
                    if (downStream.peek() < A[i]) {
                        // eat downstream fish
                        downStream.pop();
                    } else {
                        // got eaten itself
                        break;
                    }
                }
                if (downStream.isEmpty()) {
                    // all downstream go eaten -> upstream is alive
                    alive += 1;
                }
            }
        }

        return alive + downStream.size();
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});
        System.out.println(solution);
    }

}
