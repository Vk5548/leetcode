class Solution {
    int m, n;
    int[][] seen;
    int[][] directions = new int[][]{{0,-1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        m = grid.length;
        n = grid[0].length;
        seen = new int[m][n];
        int CurrArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && seen[i][j] == 0){ //if Land && not seen
                    seen[i][j] = 1;
                    CurrArea = dfs(i, j, grid);
                    System.out.println(CurrArea);
                    maxArea = Math.max(maxArea, CurrArea);
                    CurrArea = 0;
                }
            }
        }
        return maxArea != Integer.MIN_VALUE ? maxArea : 0;
    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private int dfs(int i, int j, int[][] grid){
        int area = 1;
        //getting neighbors:
        for(int[] dir : directions){ //dir = [x,y]
            int newI = i + dir[0], newJ = j + dir[1];
            if(isValid(newI, newJ) && grid[newI][newJ] == 1 && seen[newI][newJ] == 0){
                seen[newI][newJ] = 1;
                area  += dfs(newI, newJ, grid);

            }
        }
        return area;
    }
}