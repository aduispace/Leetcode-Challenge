/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

// Solution1: O(N^2), TLE
class Solution {
    public String shortestPalindrome(String s) {
        // s: aacecaaa
        // s.reverse(): aaacecaa
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder temp = new StringBuilder(s);
        String reversed = temp.reverse().toString();
        String min = "";
        for (int i = 0; i < s.length(); i++) {
            if (reversed.substring(i, s.length()).equals(s.substring(0, s.length() - i))) {
                // 第一个找到的就是前半部分最大palindrome, 直接return
                return reversed.substring(0, i) + s;
            }
        }
        return "";
    }
}


// Solution2: O(N^2)，提前退出，不会TLE
class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end = end - 1; // this makes the algorithm O(N^2)
                j = end;
            }
        }
        // ************************ 这个特殊条件为了对付"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"的特殊情况，提前return
        if (end == s.length() - 1) {
            return s;
        }
        // *********************
        StringBuilder sb = new StringBuilder(s);
        for (int k = end + 1; k < arr.length; k++) {
            sb.insert(0, arr[k]);
        }
        return sb.toString();
    }
}

// Solution3: KMP
