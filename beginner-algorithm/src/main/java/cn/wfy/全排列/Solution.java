package cn.wfy.全排列;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/5
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1, 3, 4, 8, 12, 34};
        int[] nums = new int[]{1, 3, 12, 41};
        List<List<Integer>> permute = solution.permute(nums);
        permute.forEach(System.out::println);
    }

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                if (!res.contains(track)) {
                    res.add(new LinkedList<>(track));
                }
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
