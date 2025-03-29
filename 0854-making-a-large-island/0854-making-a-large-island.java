/* 
1 0 1 0
1 0 1 1 // dfs woukld give us 4 and 6
1 0 1 1
1 0 1 0

CQ
1. can grid be empty = [], no, n != 0
2. what happens whne n = 1, return 1
3. 3 cases come to mind 
    if : no two islands can be merged after adding atmost 1, 
        add to the larger island and return
    else : 
        merge the 2 island

    
    say, I start from 0, 0 (BFS?DFS)
     if arrive at 1, then add to the area of curr island
     if arrive at 0: add at most 1, and count the length and if its greter than maxIsalnd

    --> start BFS from where?
    or is it a question of number of connected componnets
    where start DFS or BFS from every node that's not yet visited 




*/
class Solution {
    private int n ;
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean isValidCell(int[][] grid, int x, int y){
        return x >= 0 && y>= 0 && x < n && y < n ; //valid non-visited cell
    }
    private int dfs(int[][] grid, int i, int j, int id){
        if(grid[i][j] != 1){
            return 0;
        }
        int result = 1;
        if(grid[i][j] == 1){ // if its no 0 and id (visited)
            grid[i][j] = id; // mark it visited
            //traverse the neighbors
            for(int[] dir: directions){
                int row = i + dir[0];
                int col = j + dir[1];
                if(isValidCell(grid, row, col) && grid[row][col] == 1){ //if its not visited
                   result += dfs(grid, row, col, id);
                }
            }
        }
        return result;
    }
    public int largestIsland(int[][] grid) {
        this.n  = grid.length;
        int id = 100; // arbitrary value
        Map<Integer, Integer> componentMap = new HashMap<>(); // id = size
        //traverse through the grid
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){ 
                    //start DFS, also send an id
                    int size = dfs(grid, i, j, id);
                    componentMap.put(id++, size);
                }
            }
        }

        //start traversal form all zeros, see if its neighbors
        // have an value > 1
        // get the value
        // return the result

        int maxIsland = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                
                if(grid[i][j] == 0){ // now start from all the zeroes
                    Set<Integer> seen = new HashSet<>(); // add IslandID
                    //start DFS, also send an id
                    int size = 1;
                    //just visite all the neighbors and get the value
                    for(int[] dir : directions){
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if(isValidCell(grid, r, c) && grid[r][c] > 1){ 
                            int islandId = grid[r][c]; //add only once for 1 id
                            if (seen.add(islandId) ){
                                size += componentMap.get(islandId);
                            }   
                        }
                    }
                    //after all directions
                    //count the size of all seen
                   maxIsland = Math.max(maxIsland, size);
                }
            }
        }

        return maxIsland == 0 ? n * n : maxIsland;
    }
}