
class State{
    int row, col, remainder;
    State(int r, int c, int remainder){
        row = r;
        col = c;
        this.remainder = remainder;
    }
}
class Solution {
    int m, n, k;
    int[][] seen;
    int[][] directions = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        seen = new int[m][n];
        if (m == 1 && n == 1) return 0; // where start and end are same

        // so we start bfs from (0,0)
        if(grid[0][0] + grid[m-1][n-1] >= k){
            return -1;
        }
        for (int[] row : seen) {
            Arrays.fill(row, -1);
        }
        return bfs(grid, k);
    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private int bfs(int[][] grid, int k){
        Queue<State> q = new LinkedList<>();
        // we start from 0, 0
        int allowed = k;
        // if(grid[0][0] == 1){ // if obstacle at 0
        //     allowed--;
        // }
        q.add(new State(0, 0, allowed)); // added onto the Queue
        seen[0][0] = 1;
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){
                State state = q.poll();
                int row = state.row, col = state.col, remainder = state.remainder;
                //we will only add onto queue: if the path is valid else we won't explore the path
                //traversing all the neighbors
                for(int[] direc : directions){
                    int newRow = row + direc[0], newCol = col + direc[1];
                    if(newRow == m-1 && newCol == n-1){ // if we reach the target index
                            if(grid[newRow][newCol] == 0){
                                return level;
                            }else{ // if the cell values is 1
                                if(state.remainder > 0){
                                    return level + 1;
                                }else{
                                    return -1;
                                }
                            }
                    }
                    if(isValid(newRow, newCol)){
                        int newRemainder = remainder - grid[newRow][newCol];
                        if (newRemainder >= 0 && (seen[newRow][newCol] == -1 || seen[newRow][newCol] < newRemainder)) {
                            seen[newRow][newCol] = newRemainder;
                            q.add(new State(newRow, newCol, newRemainder));
                        }
                        
                        
                    }

                }
            }
            
        }
        return -1;
    }
}