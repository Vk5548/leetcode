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
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
        return head;
       }

       ListNode newHead = reverseList(head.next); // reaching end recursively

       //if head's next is not null
       //reverse the link
       head.next.next = head; //make the new link in the opposite direction,
       head.next = null; //destroy the old linkreturn 
       return newHead;
    }
}