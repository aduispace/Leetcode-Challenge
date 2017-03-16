/**
 * Solution1: Iteratively, you need three pointers, the slowest to locate previous node, 
 * the fastest to locate next node, the current(head) to locate current node;
 * 
 * Time Complexity: O(N)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = null;
        ListNode fast = head; // fast starts from head! 
        while (head != null) {
            fast = head.next; 
            head.next = slow;
            slow = head;
            head = fast;
        } // finally, head and fast point to null, and slow point to original last node (now will be the first node, i.e. head)
        return slow;
    }
}


*****************************************************************************************************************************

/**
 * Solution2 : Recursively. Must find the 
 * 
 * 1) iteration's ending condition 2) the common pattern for every time 3) what to return?
 * 
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        return reverse(head, newhead);
    }
    private ListNode reverse(ListNode head, ListNode newhead) {
        if (head != null) { // iteration's end condition!
            ListNode runner = head.next;
            head.next = newhead; // head.next = xxx -> (the node head refering to) points to xxx!
            newhead = head;
            head = runner;
            return reverse(head, newhead); // 这个递归是在去的路上reverse了, 
            //return a ListNode and this ListNode comes from reverse( , )function
        } else {
            return newhead;
        }
    }
}

