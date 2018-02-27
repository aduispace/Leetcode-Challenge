/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/


// 1. dp解法: O(N^2)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        // edge case
        if (nums == null || nums.length == 0) return maxLength; 
        // dp array
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxSub = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 前提是尾值 < nums[i]
                    // 将dp[i]更新为之前最大的dp值，即之前最长subsequence
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i] = dp[i] + 1;
            maxSub = Math.max(dp[i], maxSub); // 更新全局最大值
        }
        
        return maxSub;
    }
}

// 2. DP with Binary Search: O(NlogN)

