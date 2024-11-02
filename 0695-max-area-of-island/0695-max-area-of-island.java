class Solution {
    int m, n;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //explain this to interviewer
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = Integer.MIN_VALUE, currArea = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    currArea = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea != Integer.MIN_VALUE ? maxArea : 0 ;
    }
    private boolean isValid(int x, int y, int[][] grid){
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1;
    }
    private int dfs(int row, int col, int[][] grid){
        //mark it visited
        grid[row][col] = 0;
        int result = 1;
        //visiting the neighbors
        for(int[] dir: directions){
            int newRow = row + dir[0], newCol = col + dir[1];
            if(isValid(newRow, newCol, grid)){
                result += dfs(newRow, newCol, grid);
            }
        }
        return result;
    }
}