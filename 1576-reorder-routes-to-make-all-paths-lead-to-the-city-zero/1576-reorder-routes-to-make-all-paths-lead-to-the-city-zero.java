
class Pair{
    int node;
    int ifExist;
    Pair(int node, int ifExist){
        this.node = node;
        this.ifExist = ifExist;
    }
}
class Solution {
    int result = 0;
    Map<Integer, List<Pair>> adjacentMap; // node: List<Pair()>=> a: [Pair(b, ifExist)];
    Set<Integer> visited;
    public int minReorder(int n, int[][] connections) {
        adjacentMap = new HashMap<>();
        visited = new HashSet<>();
        //total n nodes from 0 to n-1
        //connections have a -> boolean
        for(int[] edge: connections){
            //for every edge, I am creating an edge in opposite direction
            int a = edge[0];
            int b = edge[1];
            if(!adjacentMap.containsKey(a)){
                adjacentMap.put(a, new ArrayList<>());
            }
            // adding the original edge
            adjacentMap.get(a).add(new Pair(b, 1));
            //checking if a list exists for key: b
            if(!adjacentMap.containsKey(b)){
                adjacentMap.put(b, new ArrayList<>());
            }
            // adding the now-created edge
            adjacentMap.get(b).add(new Pair(a, 0));
        }

        // We already have a connected graph, since constraints say that: only 1 path exists between any 2 nodes 
        //total of n-1 edges; so nodes are connected
        // Now at this point: after making the adjacency list every node is reachable from 0: so any edge going
        //away from 0; has to be reversed technically;
        //So, I am starting the dfs from 0
        // visited.add(0);
        dfs(0);
        return result;
    }
    private void dfs(int node){
        //starting from neighbors of 0
        for(Pair pair : adjacentMap.get(node)){ // all the neighbors of teh current node
            visited.add(node);
            int neighbor = pair.node;
            int ifExist = pair.ifExist;
            if(!visited.contains(neighbor)){
                // I also have to check if the edge from 0 is "1"; if yes; needs to be reverted
                result += ifExist == 1 ? 1 : 0; // also have to see if its visited?
                // I have to run the dfs on this neighbor
                dfs(neighbor);
            }
           
        }
    }
}