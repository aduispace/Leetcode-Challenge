/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

/** 
 * Reminder: "H H    " -> prints out 1
 * Time: O(N)
 * Space: O(1)
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1 && s.charAt(0) != ' ') {
            return 1;
        } 
        /* don't count the last several spaces! */
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
