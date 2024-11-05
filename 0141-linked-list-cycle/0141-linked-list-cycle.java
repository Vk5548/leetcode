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
public class Solution {
    public boolean hasCycle(ListNode head) {
        //an empty list is no cycle or a list with 1 node is no cycle
        if(head == null || head.next == null){
            return false;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while(ptr2!= null && ptr2.next != null){
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if(ptr1 == ptr2){
                return true;
            }
        }
        return false;
    }
}