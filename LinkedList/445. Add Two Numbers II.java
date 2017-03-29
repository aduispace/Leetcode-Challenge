/*
* Time Complexity: O(3N)
* Space Complexity: O(2N)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> cache1 = new Stack<Integer>();
        Stack<Integer> cache2 = new Stack<Integer>();
        ListNode dummy1 = l1;
        ListNode dummy2 = l2;
        while (dummy1 != null) {
            cache1.push(dummy1.val);
            dummy1 = dummy1.next;
        }
        while (dummy2 != null) {
            cache2.push(dummy2.val);
            dummy2 = dummy2.next;
        }
        ListNode tail = null;
        int divisor = 0;
        /* sum up here, be careful to the highest digit */
        while (!cache1.empty() || !cache2.empty() || divisor > 0) {
            int remain = 0;
            int pop1 = cache1.empty()? 0:cache1.pop();
            int pop2 = cache2.empty()? 0:cache2.pop();
            remain = (pop1 + pop2) % 10; 
            
            ListNode head = new ListNode(0);
            head.val = (remain + divisor) % 10; // note the number in node should be <= 9
            head.next = tail;
            
            divisor = (pop1 + pop2 + divisor) / 10; // old divisor should be add to it in case of [1],[9,9]
            tail = head; 
        }
        return tail;
    }
}
