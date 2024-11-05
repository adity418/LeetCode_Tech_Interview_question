//  1. Two sum

import java.util.*;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.containsKey(target - num)) {
                return new int[] { i, numMap.get(target - num) };
            }
            numMap.put(num, i);
        }
        return new int[] {};
    }
}
