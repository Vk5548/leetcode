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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //length of the list
        int length = 0;
        if (head == null || head.next == null) return null;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        node = head;
        if(length - n > 0){
            length = length - n;
            for(int i =1; i < length; i++){
                node = node.next;
            }
            node.next = node.next.next;
        }else{
            head = head.next;
        }
        return head;
    }
}