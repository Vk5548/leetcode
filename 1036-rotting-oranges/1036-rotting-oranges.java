class Solution {
    int m, n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        m = grid.length;
        n = grid[0].length;

        int fresh = 0;
        if(m== 1 && n== 1){
            if(grid[0][0] == 1){
                return -1;
            }
            else{
                return 0;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j}); //adding all the rotting oranges here initially
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int level = -1;
        int rotten = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                //get the neighbors
                for(int[] dir: directions){
                    int row = r + dir[0], col = c +dir[1]; 
                    if(isValid(row, col) && grid[row][col] == 1){
                        rotten++;
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                    }
                }
            }
        }

        if(fresh == 0) return 0;
        
        return fresh == rotten ?  level: -1;

    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}