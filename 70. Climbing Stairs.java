/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/

class Solution {
    // dp[i] = dp[i - 1] + dp[i - 2], 需要初始化 n = 0, n = 1的情况
    public int climbStairs(int n) {
        int dp_0 = 1;
        int dp_1 = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            int cur = dp_0 + dp_1;
            dp_0 = dp_1;
            dp_1 = cur;
        }
        
        return dp_1;
    }
}
