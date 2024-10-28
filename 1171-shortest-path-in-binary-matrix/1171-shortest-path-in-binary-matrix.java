class Solution {
    int[][] seen;
    int n;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Given a matrix : n x n ; grid
        n = grid.length;
        // Return the length of the shortest clear path in Matrix
        // What's a clear path
        // If there is no clear path : return -1
        // Clear Path: path from top-left i.e from (0, 0) to the bottom-right
        // (i.e., (n - 1, n - 1)) such that: 
        // All visited cells of the path are 0? 
        // Graph is 8-directionally connected: i.e they are different and they share an edge or a corner
        // the length of a clear path: visited cells in the path
        // Constraint : path starts at top-left and ended at right-bottom
        // if You do it using bfs, you will reach (0, 0) with the shortest path:
        // it traverses level-by-level


        // We also need to keep track of visited nodes and 1 bfs call since, it has to start from 0,0
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
                    return -1;
        }
        // seen = new int[n][n];
        
        return bfs(0, 0, grid);


    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    private int bfs(int i, int j, int[][] grid){ //it's iterative
        //getting all the neighbors of the current node
        Queue<int[]> queue = new LinkedList<>(); //LIFO
        queue.add(new int[]{0, 0});
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int z = 0; z < size; z++){
                int[] currentNode = queue.poll(); // polling out from the start
                int currNodeI = currentNode[0];
                int currNodeJ = currentNode[1];

                if(currNodeI == n-1 && currNodeJ == n-1){
                    return level;
                }
                //pushing the current node's children in the queue
                // How to access the children//
                for(int x = -1; x <= 1; x++){
                    for(int y = -1; y <= 1; y++){
                        int newX = currNodeI + x, newY = currNodeJ + y;
                        if(isValid(newX, newY) && grid[newX][newY] == 0){ //making sure we enter a valid path
                            queue.add(new int[]{newX, newY});
                            grid[newX][newY] = 1;
                        }
                    }
                }
            }
            level++; //current-level unlocked
        }
        return -1;

    }
}