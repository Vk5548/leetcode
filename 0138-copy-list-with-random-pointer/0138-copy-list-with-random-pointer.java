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

class Solution {
    public Node copyRandomList(Node head) {
      //deep copy of the list: so we will map original node with new Nodes
      Map<Node, Node> map = new HashMap<>();

      Node curr = head;
      while(curr != null){
        //we start from the first Node
        //we put the node in the map
        map.put(curr, new Node(curr.val));
        curr = curr.next;
      }// at this point all the nodes have been created and mapped
      //make the connections
      curr = head;
      while(curr != null){
        Node next = curr.next;
        Node random = curr.random;
        map.get(curr).next = map.get(next);
        map.get(curr).random = map.get(random);
        curr = curr.next;
      }
      return map.get(head);

    }
}