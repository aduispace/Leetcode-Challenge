/**
 * Solution1: Recursive 
 * 
 * Notes: 1. use helper! And remember to take in both root and list, because both needed to be updated.
 *        2. inorder : left -> root -> right
 * 
 * 
 */

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>(); // List is abstract and cannot be instantiate
        }
        inorder(root, list);
        return list;
    }
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
    
}

**************************************************************
http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
