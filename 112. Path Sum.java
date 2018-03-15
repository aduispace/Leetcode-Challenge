/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

// 递归，preorder：
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }
    private boolean res = false;
    private void helper(TreeNode root, int sum) { // sum类似与String，primitive type是copy value过去（类似于immutable），所以无需backtrack
        if (root == null) return;
        if (root.val == sum && root.left == null && root.right == null) {
            res = true;
        }
        if (root.left != null) {
            helper(root.left, sum - root.val);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val);
        }
    }
}

// divide and conquer:

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val - sum == 0) return true;  // root-to-leaf的条件
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}
