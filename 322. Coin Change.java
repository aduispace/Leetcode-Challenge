/**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

// Recursion解法：与dp类似，也要maintain一个amount矩阵来减少重复运算 

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] minimal = new int[amount + 1];
        return countChange(coins, amount, minimal);
    }
    private int countChange(int[] coins, int amount, int[] minimal) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (minimal[amount] != 0) return minimal[amount]; // minimal required coins for current amount
        int minCoins = Integer.MAX_VALUE;
        for (int i : coins) {
            int res = countChange(coins, amount - i, minimal); // 小于等于0的之前返回了
            if (res >= 0 && res < minCoins) {
                minCoins = res + 1;
            }
        }
        minimal[amount] = (minCoins == Integer.MAX_VALUE)? -1 : minCoins;
        return minimal[amount];
    }
}



// DP解法：min = Math.min(min, dp[i - coins[j]] + 1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1]; 
        // dp[amount] is the answer
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1); // previous optimal num of coins + 1, 最后再选一个剪完剩最少的coin
                }
            }
            dp[i] = (min == Integer.MAX_VALUE? -1 : min);
        }
        return dp[amount];
    }
}
