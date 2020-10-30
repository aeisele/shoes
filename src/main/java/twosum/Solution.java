package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (numToIdx.containsKey(rest)) {
                return new int[]{i, numToIdx.get(rest)};
            }
            numToIdx.put(nums[i], i);
        }

        throw new RuntimeException("should not happen");
    }

    public static void main(String[] args) {
        final int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

}
