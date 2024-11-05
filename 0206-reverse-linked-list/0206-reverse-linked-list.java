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
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            //store the next ListNode
            ListNode nextNode = curr.next;
            //assign the current node's next to its previous node
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}