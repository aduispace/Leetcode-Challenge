/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.


*/

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // dp 记录的是进入当前位置时的最少血量
        // 反向遍历，从右下到左上
        
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1], 1); // 进入当前位置，至少有1滴血
        
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i], 1);
        }
        // 每一步只能往左或者往上走
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                int cur = Math.min(dp[j+1][i], dp[j][i+1]);
                dp[j][i] = Math.max(cur - dungeon[j][i], 1);
            }
        }
        
        return dp[0][0];
    }
}
