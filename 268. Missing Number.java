Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2
Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8


// XOR Solution: 
// a^a == 0; a^0 == a
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length; // n is not supposed to be in the array
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }
}

// Sum solution:
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing = missing + (i - nums[i]);
        }
        return missing;
    }
}

// Sum solution without overflow:

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }
}
