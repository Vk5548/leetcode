/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          /*
    Name - Add Two Numbers
    Link - https://leetcode.com/problems/add-two-numbers/
    Time Complexity - O(m + n)
    Space Complexity - o(1)
    Note - make use of modulo (get remainder) and division (get quotient)
*/


        int carry = 0;
        int remainder = 0;
        int sum = 0;
        ListNode head = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            sum =
                carry +
                (
                    ((l1 != null) ? l1.val : 0) +
                    ((l2 != null) ? l2.val : 0)
                );
            remainder = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(remainder);
            if (head == null) {
                head = newNode;
            } else {
                temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = null;
            }
            l1 = l1 != null ? l1.next: null;
            l2 = l2 != null ? l2.next: null;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = null;
        }
        return head;
    }
}

 