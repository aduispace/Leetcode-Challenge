
/**
 * Solution1: Use hashmap, too slow and high space consumption  
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
