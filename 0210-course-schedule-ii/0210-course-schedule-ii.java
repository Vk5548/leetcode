class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] seen;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //prereq -: [1, 0] 0 -> 1
        for(int[] edge: prerequisites){
            int a = edge[1]; // a -> b
            int b = edge[0];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        } // graph done

        seen = new int[numCourses];
        Stack<Integer> stk = new Stack();

        for(int i =0; i < numCourses; i++){
            if(seen[i] == 0){
                // dfs();
                if(hasCycle(i, stk)){
                    return new int[0];
                }
                
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!stk.isEmpty()){
            res[i++] = stk.pop();
        }
        return res;
        
    }
    private boolean hasCycle(int node, Stack<Integer> stk){
        //start processing
        if(seen[node] == 1){
            return true;
        }
        if(seen[node] == 2){
            return false;
        }
        //mark it, if not processed
        seen[node] = 1;
        //get the neighbors
        if(graph.get(node) != null){
            for(int neighbor : graph.get(node)){
                if (hasCycle(neighbor, stk)) { // check here as well
                    return true; // Cycle detected
                }
            }
        }
        stk.push(node);
        seen[node] = 2;
        return false;
    }
}