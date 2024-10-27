class Solution {
    int m, n;
    boolean[][] visited;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; 
    public int numIslands(char[][] grid) {
        // so each i, j is a node and they are connected:
        m = grid.length;
        n = grid[0].length;
        
        // a similar matrix to see : if nodes are visited:
        visited = new boolean[m][n];
        int ans = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    //count the every dfs call
                    ans++;
                    //mark it visited
                    visited[row][col] = true;
                    //traversal call : dfs 
                    dfs(row, col, grid);
                }
            }
        }

        return ans;
    }

    private boolean isValidIndex(int row, int col){
        return row >= 0 && row < m && col >= 0 && col < n;
    }
    private void dfs(int row, int col, char[][] grid){
        //visiting all neighbors of current node and running dfs on them
        for(int[] direction: directions){
            int nRow = row + direction[0] ;
            int nCol = col + direction[1];

            if(isValidIndex(nRow, nCol) && grid[nRow][nCol] == '1' && !visited[nRow][nCol]){
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, grid);
            }
            

        }
    }
}