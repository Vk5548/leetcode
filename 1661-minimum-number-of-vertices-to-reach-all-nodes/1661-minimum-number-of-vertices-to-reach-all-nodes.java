class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        // storing indegree in respective indices 
        int[] indegree = new int[n];
        for(List<Integer> edge: edges){
            int in = edge.get(1);
            indegree[in]++;      
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
    
}