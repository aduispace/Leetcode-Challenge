/**
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/


/**
 *  
 * Thought: Index covers 0 to rowIndex, since we want to get the result in-place, so we set value in the (rowIndex - 1) row to get rowIndex row.
 * 思路：第i 行有i+1个数，
 * 
 * Time Complexity：O(n^2)
 *  
 * 
 */


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        // iterate rowIndex + 1 times, where rowIndex + 1 == # of rows
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(0, 1); // [1,2,1] -> [1,1,2,1]，这步很关键，必须在生成下一列的时候，在最前面插入1，使size+1
            for (int k = 1; k < result.size() - 1; k++) {
                result.set(k, result.get(k) + result.get(k + 1)); // [1,1,2,1] -> [1,3,2,1] -> [1,3,3,1] 
            }
        }
        return result;
    }
}
