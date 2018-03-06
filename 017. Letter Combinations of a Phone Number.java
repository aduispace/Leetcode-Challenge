/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combine("", digits, phone, digits.length(), 0, res);
        return res; 
    }
    private void combine(String cur, String digits, String[] phone, int remain, int start, List<String> res) {
        if (remain == 0) {
            res.add(cur);
            return;
        }
        int index = digits.charAt(start) - '0';
        char[] arr = phone[index].toCharArray();
        for (int i = 0; i < arr.length; i++) {
            combine(cur + String.valueOf(arr[i]), digits, phone, remain - 1, start + 1, res);
        }
        
    }
}
