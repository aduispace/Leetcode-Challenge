/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper("", n, 0, 0, res);
        return res;
    }
    private void helper(String cur, int n, int left, int right, List<String> res) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (left < n) { // add left before add right
            helper(cur + "(", n, left + 1, right, res);
        }
        if (right < left) { // right must less than left
            helper(cur + ")", n, left, right + 1, res);
        }
    }
}
