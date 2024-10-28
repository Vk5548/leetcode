class Solution {
    boolean[] visited ;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        //making an adjacency lits:
        
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n];
        int numOfComponents = 0;
        for(int i = 0; i < n; i++){
            //starting dfs from every unvisited node;
            if(!visited[i]){
                visited[i] = true;
                numOfComponents++;
                dfs(i);
            }
        }
        return numOfComponents;
    }
    private void dfs(int node){
        if(graph.get(node) == null){
            return;
        }
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}