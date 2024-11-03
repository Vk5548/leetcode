// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the list is empty or has only one element, return as is
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsRecursive(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsRecursive(ListNode[] lists, int left, int right) {
        // Base case: if there's only one list, return it
        if (left == right) {
            return lists[left];
        }
        // Divide the list range in two halves
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeKListsRecursive(lists, left, mid);
        ListNode l2 = mergeKListsRecursive(lists, mid + 1, right);
        // Merge the two halves and return the merged list
        return mergeTwoLists(l1, l2);
    }

    // Helper function to merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes (if any)
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
