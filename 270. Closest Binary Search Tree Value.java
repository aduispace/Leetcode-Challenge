Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// 注意double为8bytes， int为4bytes，closest设置integer.max_value不能处理溢出
class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        closest = root.val;
        helper(root, target);
        return closest;
    }
    private int closest;
    private void helper(TreeNode root, double target) {
        if (root == null) return;
        helper(root.left, target);
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        helper(root.right, target);
    }
}
