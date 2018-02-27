/* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

// moore voting algorithm！！！
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int majority = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // count == 0，更新candidate
            if (count == 0) {
                majority = nums[i];
            }
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        
        return majority;
    }
}
