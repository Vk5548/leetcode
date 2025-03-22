/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/* 


*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        Node ptr = head;
        while(ptr != null){
            Node newNode = new Node(ptr.val);
            copy.put(ptr, newNode);
            ptr = ptr.next;
        }
        //make coonections
        ptr = head;
        while(ptr!= null){
            copy.get(ptr).next = copy.get(ptr.next);
            copy.get(ptr).random = copy.get(ptr.random);
            ptr = ptr.next;
        }
        return copy.get(head);
    }
}