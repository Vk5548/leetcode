class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] seen;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       for(int[] edge: edges){ //traversing through the edges
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u); // since its bi-directional
       }// graph ready
        seen = new int[n];
        //visit the source:
        seen[source] = 1;
        dfs(source);
        return seen[destination] == 1;
    }
    //recursive dfs
    private void dfs(int source){
        // to get the neighbors of any node, we will need the list value of the graph
        if(graph.get(source) == null){
            return;
        }
        for(int neighbor : graph.get(source)){
            if(seen[neighbor] == 0){
                seen[neighbor] = 1;
                dfs(neighbor);
            }
        }

    }
}