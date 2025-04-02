/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/* 
Graph is connected;
Adjacency list; deep copy, therefore, as I go, I will need HashMap to store the neoghbors
and then form the connections in the list
*/
class Solution {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
       if(node == null){
            return null;
       }

       if(visited.containsKey(node)){ // if already visited return
        return visited.get(node);
       }

       Node copy = new Node(node.val); //create the new node,   
       visited.put(node, copy); // put it int the Map {1: 1}

       // go onto traverse the neighbors
       for(Node nbr : node.neighbors){ //traversethrough the nodes [2, 4] in this case
           copy.neighbors.add(cloneGraph(nbr)); //we also need to add it into the list as well
       }
        
        return visited.get(node);
    }
}