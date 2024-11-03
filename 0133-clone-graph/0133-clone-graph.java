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

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        //dfs traversal I am doing
        if( node == null){
            return null;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        //add the current node to visited
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        //get the neighbors
        for(Node neighbor: node.neighbors){ //itearting through the neighbor
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}