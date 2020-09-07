package stonewall;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution {

    public int solution(int[] H) {
        int stoneCount = 0;
        Deque<Integer> openStones = new ArrayDeque<>();
        for (int height : H) {
            if (openStones.isEmpty()) {
                openStones.push(height);
            } else {
                final Iterator<Integer> iterator = openStones.iterator();
                while (iterator.hasNext()) {
                    Integer lastHeight = iterator.next();
                    if (lastHeight < height) {
                        openStones.push(height);
                        break;
                    } else if (lastHeight > height) {
                        iterator.remove();
                        stoneCount++;
                    } else {
                        break;
                    }
                }
                if (openStones.isEmpty() || openStones.peek() != height) {
                    openStones.push(height);
                }
            }
        }

        return stoneCount + openStones.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

}
