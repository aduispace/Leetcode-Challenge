/* Solution1: Bit Manipulation
* we use bitwise XOR to solve this problem :

first , we have to know the bitwise XOR in java

0 ^ N = N
N ^ N = 0
So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N
*/

**************************************************************************************
/**
 * Solution1: Use bitwise -> introduce 0 -> 0^N = N; N^N = 0!
 * 
 * 
 * 
 */

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i : nums) {
            result = result ^ i; // the remaining single number will be the target
        }
        return result;
    }
}

**************************************************************************************

/**
 * Solution2: Use hashmap, too slow and high space consumption  
 * Time Complexity: O(2N)
 * Space Complexity: O(N)
 * 
 */

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int target = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int n = (map.get(nums[i])) + 1;
                map.put(nums[i], n);
            }
        }
        /* be careful of how to iterate a hashmap */
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                target = key;
            }
        }
        return target;
        
    }
}
