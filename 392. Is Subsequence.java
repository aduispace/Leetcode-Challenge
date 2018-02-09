Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

// 双指针O(max(M, N))解法

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j == t.length()) return false;
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return true;
    }
}

//Follow-Up:

// Binary search:

record the indexes for each character in t, if s[i] matches t[j], then s[i+1] should match a character in t with index bigger than j. This can be reduced to find the first element larger than a value in an sorted array (find upper bound), which can be achieved using binary search.

// Trie:

For example, if s1 has been matched, s1[last char] matches t[j]. Now, s2 comes, if s1 is a prefix of s2, i.e., s1 == s2.substr[0, i-1], we can start match s2 from s2[i], right?
So, the idea is to create a Trie for all string that have been matched so far. At a node, we record the position in t which matches this char represented by the node. Now, for an incoming string s, we first search the longest prefix in the Trie, find the matching position of the last prefix-char in t, say j. Then, we can start matching the first non-prefix-char of s from j+1.
Now, if we have done the preprocessing as stated in the binary search approach, we can be even faster.
