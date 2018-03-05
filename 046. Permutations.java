/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permu = new ArrayList<>();
        dfs(nums, permu, res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> permu, List<List<Integer>> res) {
        if (permu.size() == nums.length) {
            res.add(new ArrayList<Integer>(permu));
            return;
        } 
        
        for (int i : nums) {
            if (permu.contains(i)) continue;
            permu.add(i);
            dfs(nums, permu, res);
            permu.remove(permu.size() - 1);
        }
    }
}
