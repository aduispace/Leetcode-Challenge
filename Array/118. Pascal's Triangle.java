/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

/**
 * Time Complexity: O(n^2)
 * 思路：先加[1]进去，接下来新加的每一个list都有[1,...,1]的格式，且都需要上一个list生成list.get(k) + list.get(k+1)
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return result;
        }
        /* now numRows is at least 1 */
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list); // now result at least has {[1], ....}
        for (int i = 1; i < numRows; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1); // newList should follow the format that [1,...,1]
            List<Integer> lastList = new ArrayList<Integer>(); // the list before newList
            lastList = result.get(i - 1);
            for (int k = 0; k < lastList.size() - 1; k++) {
                newList.add(lastList.get(k) + lastList.get(k + 1));
            }
            newList.add(1);
            result.add(newList);
        }
        return result;
    }
}
