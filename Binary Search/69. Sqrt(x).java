/* 
 * Time Complexity: O(log(n))
 * Thoughts: Be aware of several corner cases like x == 1 and x == 2!
*/

public class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        long tempx = x;
        long start = 0;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == tempx) {
                return (int)mid;
            } else if (mid * mid < tempx) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }
}
