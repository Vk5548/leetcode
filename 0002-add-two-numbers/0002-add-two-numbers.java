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
 a LL, non-empty, non-negative, >=0, 
 sorted in reverse order, add 2 nums and return the sum as LL

 Q:What if one of the ll is empty?
 Q: what is the max length of 1 link list?
 Q: // 234 => 4 -> 3> 2? 
 Q: zre there leading zeroes
 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode res = new ListNode(0);
        ListNode holder = res;

        int sum = 0, carry = 0;

        //iterate 
        while(l1 != null || l2 != null ){
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            int remainder = sum % 10; //new ListNode
            carry = sum / 10;
            ListNode newNode = new ListNode(remainder);
            res.next = newNode;
            res = newNode;
            res.next = null;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry > 0){
            res.next = new ListNode(carry);
            res = res.next;
            res.next = null;
        }
        return holder.next;

    }
   
}