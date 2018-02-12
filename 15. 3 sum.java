Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Time: O(NlogN + N^2)

// 先sort，然后一个for找负数，剩下用two pointer确定
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums == null) return res;
        Arrays.sort(nums); // O(NlogN)
        if (nums[0] > 0) return res;
        // only need to sweep to the third to last item
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i - 1] == nums[i])) continue; // skip the duplicate elements for i, 前面有一样的可以跳过
            int target = 0 - nums[i];
            int m = i + 1;
            int j = nums.length - 1;
            while (m < j) {
                if (nums[m] + nums[j] == target) {
                    List<Integer> cur = new ArrayList<Integer>(Arrays.asList(nums[i], nums[m], nums[j]));
                    res.add(cur);
                    while (m < j && nums[m] == nums[m + 1]) m++; // 缩小范围里面有一样的，可以跳过
                    while (m < j && nums[j] == nums[j - 1]) j--;
                    m++;
                    j--;
                } else if (nums[m] + nums[j] > target) {
                    j--;
                } else {
                    m++;
                }
            }
        }
        return res;       
    }
}
