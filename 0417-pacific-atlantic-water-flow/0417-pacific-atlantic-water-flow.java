class Solution {
    int m, n;
    int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length; // rows
        n = heights[0].length; // cols

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // HashSet<int[]> seenPacific = new HashSet<>();
        // HashSet<int[]> seenAtlantic = new HashSet<>();

        boolean[][] pacificSeen = new boolean[m][n];
        boolean[][] atlanticSeen = new boolean[m][n];



        //the cells which definitely will reach pacific
        //top row
        for(int i = 0 ; i < n; i++){ //traversing the cols
            //pacific
            pacificQueue.add(new int[]{0, i});
            pacificSeen[0][i] = true;

            //atlantic
            atlanticQueue.add(new int[]{m-1, i});
            atlanticSeen[m-1][i] = true;
        }

        //left-col+
        for(int i = 0; i < m; i++){
            //pacific
            pacificQueue.add(new int[]{i, 0});
            pacificSeen[i][0] = true;

            //atlantic
            atlanticQueue.add(new int[]{i, n-1});
            atlanticSeen[i][n-1] = true;
        }

        //starting bfs from both pacific and atlantic
        //on pacific
        bfs_coord(pacificQueue, heights, pacificSeen);
        bfs_coord(atlanticQueue, heights, atlanticSeen);

         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificSeen[i][j] && atlanticSeen[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;

    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void bfs_coord(Queue<int[]> q, int[][] heights, boolean[][] seen){
        // HashSet<int[]> res = new HashSet<>();

        while(!q.isEmpty()){
            int[] co_ord = q.poll();
            int row = co_ord[0];
            int col = co_ord[1];
            // res.add(co_ord);

            //get the neighbors
            for(int[] dir: directions){
                int newRow = row + dir[0], newCol = col + dir[1]; 
                if(isValid(newRow, newCol) &&   !seen[newRow][newCol] && heights[newRow][newCol] >= heights[row][col] ){
                    seen[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }

            }

        }
    }

    
}