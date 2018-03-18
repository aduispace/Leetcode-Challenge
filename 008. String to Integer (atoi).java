/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        // if (str.length() == 1) {
        //     return (str.charAt(0) - '0' >= 0 && str.charAt(0) - '0' <= 9)? str.charAt(0) - '0' : 0;
        // }
        int base = 0, start = 0, sign = 1;
        while (str.charAt(start) == ' ') {
            start++;
        }
        if (str.charAt(start) == '+' || str.charAt(start) == '-') {
            sign = str.charAt(start) == '+'? 1 : -1;
            start++; //!!!
        }
        for (int i = start; i < str.length(); i++) { // 从start下一个开始
            if (!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)) {
                break; // test case :1131312312o4
            }
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0'> Integer.MAX_VALUE % 10)) {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                base = base * 10 + (str.charAt(i) - '0');
            }
        }
        // int i = start;
        // while (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
        //     if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0'> Integer.MAX_VALUE % 10)) {
        //         return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //     } 
        //     base = base * 10 + (str.charAt(i) - '0');
        //     i++;
        // }
        return base * sign;
    }
}
