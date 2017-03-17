/**
 * Solution1: two loops, time exceed, need to be modified
 * Time Complexity: O(N^2)
 * 
 * Note: 1) 0 and 1 are neither prime and composite 2) here, less than n means <n
 *  
 */

public class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int counter = 0;
        /* start from the smallest possible prime number: 2 */
        for (int i = 2; i < n; i++) {
            boolean judge = true;
            /* the inner loop won't divided by 1 or number itself */
            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    judge = false;
                }
            }
            if (judge == true) {
                counter++;
            }
        }
        return counter;
    }
}
