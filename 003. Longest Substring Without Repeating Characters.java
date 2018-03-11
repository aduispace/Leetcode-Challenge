/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

// sliding window + hashmap

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>(); // <char, index>
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                // update the map and left, 注意这个left不能回头，即不能取之前重复index+1！！！;
                left = Math.max(map.get(s.charAt(i)) + 1, left);
                map.put(s.charAt(i), i);
            }
            max = Math.max(max, i - left + 1);
        }
        
        return max;
    }
}
