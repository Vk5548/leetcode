class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> restrict ;
    int[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        if(restricted.length == 0) return n;
        for(int[]edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        } // graph is done
        //converted restricted[] into set
        restrict= new HashSet<>();
        for(int num : restricted){
            restrict.add(num);
        }
        
        if (restrict.contains(0)) return 0;
        seen = new int[n];
        seen[0] = 1;
        return dfs(0);
    }
    private int dfs(int node){
        int numNodes = 1;
        //visiting all neighbors
        for(int neighbor :  graph.get(node)){
            if(!restrict.contains(neighbor) && seen[neighbor] == 0){
                seen[neighbor] = 1;
                numNodes += dfs(neighbor);
            }
        }
        return numNodes;
    }
}