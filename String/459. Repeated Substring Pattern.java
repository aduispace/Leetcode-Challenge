/* First Thought: use hashmap（不对），注意，自己不能算自己的substring!!!
   这种和substring次序有关的不能用hashmap！

   Second Thought: 
   substring自身不算，所以substring partition个数至少为2，length is even! 
  
   Thoughts: 
   The length of the repeating substring must be a divisor of the length of the input string
   Search for all possible divisor of str.length, starting for length/2
   If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
   If the repeated substring is equals to the input str return true
   
   Time Complexity: O(len) == O(N);
   Space Complexity: O(N);
*/

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int half = len / 2;
        if (len <= 1) {
            return false;
        }
        for (int i = half; i > 0; i--) {
            if (len % i == 0) { // 全长能整除才有可能为substring
                int m = len / i; // 重复m次才可能还原回原string
                String str = s.substring(0, i); // substring will exclude index i, it means substring is from 0 to (i-1) 
                StringBuilder sb = new StringBuilder();
                for (int k = 1; k <= m; k++) {
                    sb.append(str);
                }
                if(sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
