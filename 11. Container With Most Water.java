/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

// 每次在更小的height位置前进一步
class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int res = 0;
        while (start < end) {
            res = Math.max(res, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) 
                start++;
            else 
                end--;
            
        }
        return res;
    }
}

// class Solution {
//     public int maxArea(int[] height) {
//         int maxarea = 0, l = 0, r = height.length - 1;
//         while (l < r) {
//             maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
//             if (height[l] < height[r])
//                 l++;
//             else
//                 r--;
//         }
//         return maxarea;
//     }
// }
