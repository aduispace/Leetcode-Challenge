/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/


class Solution {
    
    // dp[i] stands for whether subarray(0, i) can be segmented into words from the dictionary. So dp[0] means whether subarray(0, 0) ->这种情况不取0 (which is an empty string) can be segmented, and of course the answer is yes. The default value for boolean array is false. Therefore we need to set dp[0] to be true.
    
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // make sure substring(j, i) can be found in dict
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[s.length()];
        
    }
}
