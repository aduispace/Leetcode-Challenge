/* Example. Suppose we would like to add two binary numbers 10 and 11. We start from the last digit. 
   Adding 0 and 1, we get 1 (no carry). That means the last digit of the answer will be one. 
   Then we move one digit to the left: adding 1 and 1 we get 10. Hence, the answer is 101. 
   Note that binary 10 and 11 correspond to 2 and 3 respectively. 
   And the binary sum 101 corresponds to decimal 5: is the binary addition corresponds to our regular addition. 
   Thanks to: http://web.math.princeton.edu/math_alive/1/Lab1/BinAdd.html

   Examples: 11 + 11 = 110
   
   Thoughts: 用类two pointers法, but both in reverse order!
   
   Tricky parts: 1. carry should restored to 0 after add to sum!
                 2. don't to reverse the sb, because you use append()!
                 3. forget to consider that the last digit of both might also trigger a carry
*/

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int k = b.length() - 1;
        
        int carry = 0; // reserve for carry digit
        
        /* determine separately to add carry or not */
        while (i >= 0 || k >= 0) {
            int sum = 0; // this is a counter, count String a firstly then b
            if (i >= 0) {
                sum = sum + carry + (a.charAt(i) - '0');
                carry = 0; // to avoid add twice
                i--;
            }
            if (k >= 0) {
                sum = sum + carry + (b.charAt(k) - '0');
                carry = 0;
                k--;
            }
            /* determine carry = 1 or carry = 0? */
            if (sum >= 2) {
                carry = 1;
            }
            /* determine what number to append to the sb */
            sum = sum % 2;
            sb.append(sum); 
            
            /* tricky part, forget to consider that the last digit of both might also trigger a carry */
            if (i < 0 && k < 0 && carry == 1) {
                sb.append(carry);
            }
            
        }
        
        return sb.reverse().toString();
        
    }
}
