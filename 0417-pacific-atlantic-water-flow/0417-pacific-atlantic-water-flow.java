class Solution {
    int m, n;
    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] pacificSeen = new boolean[m][n];
        boolean[][] atlanticSeen = new boolean[m][n];
        
        // Process first and last row
        for (int col = 0; col < n; col++) {
            // Start DFS from Pacific Ocean (top row)
            dfs(0, col, pacificSeen, heights, heights[0][col]);
            // Start DFS from Atlantic Ocean (bottom row)
            dfs(m-1, col, atlanticSeen, heights, heights[m-1][col]);
        }
        
        // Process first and last column
        for (int row = 0; row < m; row++) {
            // Start DFS from Pacific Ocean (left column)
            dfs(row, 0, pacificSeen, heights, heights[row][0]);
            // Start DFS from Atlantic Ocean (right column)
            dfs(row, n-1, atlanticSeen, heights, heights[row][n-1]);
        }
        
        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificSeen[i][j] && atlanticSeen[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int row, int col, boolean[][] seen, int[][] heights, int prevHeight) {
        // Check bounds, visited status, and height requirement
        if (row < 0 || row >= m || col < 0 || col >= n || 
            seen[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        
        seen[row][col] = true;
        
        // Explore all four directions
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], seen, heights, heights[row][col]);
        }
    }
}