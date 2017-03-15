/**
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

// Solution 1 with pq:

/**
 * Thought: PriorityQueue, note that under the natural ordering, the top of heap is minimum.
 * 
 * Time Complexity: O(N+log(N))
 */ 

public class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        int thirdMax;
        for (int i : nums) {
            if (!pq.contains(i)) { // make sure there is no duplicate value!!!
                pq.offer(i); 
            }
        }
        while (pq.size() > 3) {
            pq.poll();
        }
        if (pq.size() == 3) {
            thirdMax = pq.poll();
        } else {
            while (pq.size() > 1) {
                pq.poll();
            }
            thirdMax = pq.poll();
        }
        return thirdMax;
    }
}
