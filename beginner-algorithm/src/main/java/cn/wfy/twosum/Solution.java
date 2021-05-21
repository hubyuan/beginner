package cn.wfy.twosum;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indexs = solution.solute(nums, target);
    }

    private int[] solute(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
//            hashMap.put();
        }
        return null;

    }
}
