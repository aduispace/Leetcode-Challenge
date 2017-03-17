/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 1); // if the root is not null (root node exists), start with 1, because the depth is at least 1!
    }
    private int result = 0;
    private int helper(TreeNode root, int sum) {
        int cur = sum;
        if (root.left == null && root.right == null) {
            result = Math.max(cur, result);
        } else if (root.left != null && root.right != null){
            cur++;
            helper(root.left, cur); // Recursion到这里要非常注意！左右都可以走，先走左，走不通回到root上再走右！
            helper(root.right, cur);
        } else if (root.left != null && root.right == null){
            cur++;
            helper(root.left, cur);
        } else {
            cur++;
            helper(root.right, cur);
        }
        return result;
    }
}
