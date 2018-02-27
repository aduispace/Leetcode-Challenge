Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// iteration:

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. merge two list问题都需要 假head 和 prev指针
        // 2. 注意最后一个listnode未被包含进去！
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null ? l2 : l1);
        
        return head.next;
    }
}
