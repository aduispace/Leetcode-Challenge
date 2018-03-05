Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode wrong_1 = null;
    private TreeNode wrong_2 = null;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE); // 不能为空，不然会Null pointer

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = wrong_1.val; // 直接换value
        wrong_1.val = wrong_2.val;
        wrong_2.val = temp;
    }
    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && pre.val > root.val) {
            if (wrong_1 == null) {
                wrong_1 = pre;
            }
            wrong_2 = root;
        }
        pre = root;
        helper(root.right);
    }
}
