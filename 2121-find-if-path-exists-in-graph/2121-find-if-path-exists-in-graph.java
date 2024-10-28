class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        //prerocessing the graph
        // I have edges: an array
        // I am thinking to make an adjacency list??
        //So, I think I will use a HAshMap?? : O(1): look-up operation
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited.add(source);
        dfs(source, visited, graph);
        return visited.contains(destination);

    }
    private void dfs(int source, Set<Integer> visited, Map<Integer, List<Integer>> graph){
        // getting the neighbors of the source node and running dfs on it
        if(graph.get(source) == null){
            return;
        }
        for(Integer neighbor: graph.get(source)){
            if(neighbor != null){
                if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(neighbor, visited, graph);
            }
        }
            
        }
    }
}