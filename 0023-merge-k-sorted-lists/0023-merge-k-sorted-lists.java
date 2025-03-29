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

 /* 
 CQ: 
 1 can k be 0? an empty list : new ListNode()
 2 can be k fit in 32-bit int?
 3. every list in the array is guaranteed to be sorted?


A: minHeap, to get the lelemnet from each list that goes next and then add another element from the said list
T: O(nlogk) n: total number of elelmnst from all the list 
5_000_000

 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if( k == 0 ) return null;
        if( k == 1 ) return lists[0];
        ListNode head = new ListNode(-10001);
        ListNode sentinel = head; //holder

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.val, n2.val));
        // add all the first element of al k lists
        for(int i = 0; i < k; i++){
            if(lists[i] != null)
                minHeap.offer(lists[i]);
        }

        while(!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            head.next = new ListNode(n.val);
            head = head.next;
            if(n.next != null)
                minHeap.offer(n.next);
        }

        return sentinel.next;

    }
}