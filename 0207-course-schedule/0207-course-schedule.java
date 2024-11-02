class Solution {
    Map<Integer, List<Integer>> graph= new HashMap<>();
    int[] seen ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int[] edge: prerequisites){
            int a = edge[0];
            int b = edge[1]; // to be accomplished before
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);
        }// graph made
        // if all the courses are possible?
         // how do we know which node to start from?
        seen = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(graph.containsKey(i)){
                //start dfs
               if(seen[i] == 0 && hasCycle(i)) {
                    return false;
               }
                
            }
        }
        return true;
    }
    private boolean hasCycle(int n){
        if(seen[n] == 1) return true;
        if(seen[n] == 2) return false;
        seen[n] = 1;
        
        //get the neighbors
        if(graph.get(n) != null) {
            for(int neighbor: graph.get(n)){
               if (hasCycle(neighbor)) {
                    return true;
                }
          
            }
        }
        seen[n] = 2;
        return false;
    }
}