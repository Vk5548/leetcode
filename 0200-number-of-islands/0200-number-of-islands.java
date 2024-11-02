class Solution {
    int m, n;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] seen;
    public int numIslands(char[][] grid) {
        m = grid.length; //rows
        n = grid[0].length; //cols:
        int result = 0;
        seen = new int[m][n];
        //we start dfs ortraverse the matrix and start the dfs from the first land
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && seen[i][j] == 0){
                    //start dfs
                    seen[i][j] = 1;
                    result++;
                    // grid[i][j] = '0';
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }
    private boolean isValid(int x, int y, char[][] grid){
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1';
    }
    private void dfs(int i , int j, char[][] grid){
        // we nees to start getting the neighbors
        for(int[] dircetion : directions){
            int row = i + dircetion[0], col = j + dircetion[1];
            if(isValid(row, col, grid) && seen[row][col] == 0){
                seen[row][col] = 1;
                
                dfs(row, col, grid);
            }
        }
    }
}