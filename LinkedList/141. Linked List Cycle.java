/** 
  Given a linked list, determine if it has a cycle in it.
  Follow up:
  Can you solve it without using extra space? In-place
  If not in-place, use hashmap!
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /**
  * Time Complexity: O(N)
  * Space Complexity: O(1) 
  * 
  * 注意两种有环的情形:
  * 1. 1 -> 2 -> 3 -> 4 -> 5 -> 3 局部有环
  * 2. 1 -> 2 -> 3 -> 4 -> 5 -> 1 一整个是个大环 （环一旦进去出不来）
  * 
  */ 
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
