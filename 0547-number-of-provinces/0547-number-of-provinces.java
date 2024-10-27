class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> graph;
    public int findCircleNum(int[][] isConnected) {
        // first step is to build the graph
        graph = new HashMap<>();

        int n = isConnected.length;
        for(int i = 0; i< n; i++){
            //creating a list for every node as we reach them
            if(!graph.containsKey(i)){
                graph.put(i, new ArrayList<>());
            }
            // traversing and noting the edges
            for(int j = i + 1; j < n; j++){ // i and j won't ever be equal
                //creating an entry for the j node if it doesn't already exist
                if(!graph.containsKey(j)){
                    graph.put(j, new ArrayList<>());
                }
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        visited = new boolean[n];
        int numOfProvinces = 0;
        for(int i =0; i< n; i++){
            if(!visited[i]){ //if not visisted yet
                visited[i] = true;
                numOfProvinces++;
                dfs(i);
            }
        }
        return numOfProvinces;

    }

    private void dfs(int node){
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}