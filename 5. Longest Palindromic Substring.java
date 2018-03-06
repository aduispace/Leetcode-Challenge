/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        } 
        if (s.length() == 1) {
            return s;
        }
        
        
        int min_index = 0;
        int max_index = 0;
        int max_length = 1; // at least 1!
        for (int i = 0; i < s.length(); i++) {
            // 为了避免奇偶的情况
            // find first non-repeated char on the left
            int left = i - 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) left--;
            
            // find first non-repeated char on the right
            int right = i + 1;
            while (right < s.length() && s.charAt(right) == s.charAt(i)) right++;
            
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            
            if ((right - left - 1) > max_length) {
                max_length = right - left - 1; // 记得更新max_length
                min_index = left + 1;
                max_index = right - 1;
            } 
        }
        return s.substring(min_index, max_index + 1);
    }
}
