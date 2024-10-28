class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited.add(0); //since we start from 0;
        dfs(0, rooms); // we start the dfs from 0;
        return visited.size() == rooms.size();

    }
    private void dfs(int node, List<List<Integer>> rooms){
        for(int room : rooms.get(node)){ // getting neighbors of node
            if(!visited.contains(room)){
                visited.add(room); // marking them as visited
                dfs(room, rooms); // calling the dfs on first neighbor
            }       
        }
    }
}