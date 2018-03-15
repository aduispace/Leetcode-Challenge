/*

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

*/

class Solution {
    public int rob(int[] nums) {
        // index = 0 and index = nums.length - 1 cannot be robbed at the same time!
        // 思路就是分别考虑[0, nums.length - 2]和[1, nums.length - 1]，其中的最大值即为所求(subproblem)
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int preYes_0 = 0, preNo_0 = 0;
        int preYes_n = 0, preNo_n = 0;
        int max_0 = 0, max_n = 0;
        
        // 以下部分可以写成函数:
        // with 0 and without n
        for (int i = 0; i <= nums.length - 2; i++) {
            int curYes = preNo_0 + nums[i];
            int curNo = Math.max(preNo_0, preYes_0);
            preNo_0 = curNo;
            preYes_0 = curYes;
        }
        max_0 = Math.max(preNo_0, preYes_0);
        // with n and without 0        
        for (int i = 1; i <= nums.length - 1; i++) {
            int curYes = preNo_n + nums[i];
            int curNo = Math.max(preNo_n, preYes_n);
            preNo_n = curNo;
            preYes_n = curYes;
        }
        max_n = Math.max(preNo_n, preYes_n);
        
        return Math.max(max_n, max_0);
        
    }
}
