You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int promoted = 0;
        ListNode prehead = new ListNode(-1); // Prehead必须指向一个ListNode
        ListNode dummy = prehead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null? 0 : l1.val; // 注意两个list可能长短不一
            int val2 = l2 == null? 0 : l2.val;
            int remained = (val1 + val2 + promoted) % 10; // 余数+val1+val2
            ListNode cur = new ListNode(remained);
            dummy.next = cur; 
            promoted = (val1 + val2 + promoted) / 10;
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (promoted > 0) {
            dummy.next = new ListNode(promoted);
        }
        
        return prehead.next;
    }
}
