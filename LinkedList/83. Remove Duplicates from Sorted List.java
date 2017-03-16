/**
 * Thoughts: 1. the linkedlist is sorted, so there is no such [1,2,2,3,4,2]
 *           2. be very careful to the nullpointer exception, 
 *              check every condition to make sure won't transpass the boundary
 * 
 * Time Complexity: O(N^2), too slow! 
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode runner = head;
        while (runner != null && runner.next != null) {
   /* in case of more than 2 consecutive duplicate elements, need another loop rather than a single if statement! */
            while (runner.next != null && (runner.next.val == runner.val)) { 
                runner.next = runner.next.next;
            }
            runner = runner.next; // increment
        }
        return head;
    }
}


**************************************************************************************
// Another solution with time complexity O(N)

/**
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            if (runner.val == runner.next.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        return head;
    }
}


*******************************************************************************
// Recusive solution
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next != null && head.next.val == head.val) {
            head.next = head.next.next;
            head = deleteDuplicates(head);
        }
        else
            head.next = deleteDuplicates(head.next);
        
        return head;
        //
    } 
}
