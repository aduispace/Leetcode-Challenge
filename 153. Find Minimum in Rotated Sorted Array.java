/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/


class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        // this "if" condition will exclude some non-rotated cases
        if (nums[start] < nums[end]) {
            return nums[0];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[0] && nums[mid] > nums[nums.length - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[end]; // 如果有前面的if则直接是return end，即排除了[0,1,2,3,4,5..]的情况
        // return nums[start] <= nums[end] ? nums[start] : nums[end];
    }
}
