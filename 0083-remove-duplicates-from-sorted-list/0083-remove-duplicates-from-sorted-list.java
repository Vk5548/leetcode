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
    public ListNode deleteDuplicates(ListNode head) {
        //list is sorted
        ListNode ptr = head;

        while(ptr != null){
            if(ptr.next != null && ptr.val == ptr.next.val){
                ptr.next = ptr.next.next;
            }else{
                ptr = ptr.next;
            }
            
        }
        return head;
    }
}