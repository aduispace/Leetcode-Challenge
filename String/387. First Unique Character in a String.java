/**
 * Thoughts: Use Hashmap to record the char occurrence;
 * Time: O(N)
 * Extra Space: O(N)
 * 
 * 
 */

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 */
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), temp);
            } else {
                map.put(s.charAt(i), 1);                
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1) {
                return j;
            }        
        }
        return -1;
    }
}
