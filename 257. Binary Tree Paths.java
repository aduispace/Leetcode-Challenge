/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
 
 
// 1. Backtrack, 有点复杂
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        List<Integer> path = new ArrayList<Integer>();
        helper(root, res, path);
        return res;
    }
    private void helper(TreeNode root, List<String> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            String cur = new String(Integer.toString(path.get(0)));
            if (path.size() > 1) { 
               for (int i = 1; i < path.size(); i++) {
                   cur = cur + "->" + Integer.toString(path.get(i));
               }   
            }
            res.add(cur);  
        }
        
        helper(root.left, res, path);
        helper(root.right, res, path);
        
        path.remove(path.size() - 1);
    }
}

// 2. Divide and Conquer，用StringBuilder加速

// 注意Mutable StringBuilder需要backtrack，重置回原始长度：

// “StringBuilder” is a mutable object, it will hold its value after returning.Whereas String creates a copy in every recursion, you don’t need to worry about the “side-effect” when backtrack.


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        dfs(root, res, path);
        return res;
    }
    
    private void dfs(TreeNode root, List<String> res, StringBuilder path) {
        if (root == null) return;
        int curSize = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            dfs(root.left, res, path); // StringBuilder is mutable!! Cannot dfs(.., path.append().append()) twice!!!
            dfs(root.right, res, path);
        } 
        path.setLength(curSize);
    }
}
