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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2)-> n1.val - n2.val);
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        //start with all the first node in the heap
        for(ListNode node : lists){
            if (node != null) {
                heap.add(node);
            }
        }


        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null){
                heap.add(node.next);
            }
        }
        return dummy.next;
    }
}