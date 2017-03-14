/**

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

/**
 * First Thought : Binary Search because 1. array is sorted 2. you need to find a target
 * Second Thought :  Look carefully into three cases!
 * Time Complexity: O(n)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        /* corner cases */
        if (nums == null || nums.length == 0) {
            return -1; 
        }
        int start = 0;
        int end = nums.length - 1;
        int index = 0; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;  // Here, you must return mid, because otherwise it will take much more time and exceed the time limit!
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            }
        }
        /* three cases to consider, target <= start, start < target <= end, target > end */ 
        if (nums[start] >= target) {
            index = start;
        } else if (nums[end] < target){
            index = end + 1; 
        } else {
            index = end;
        }
        
        return index;
    }
}
