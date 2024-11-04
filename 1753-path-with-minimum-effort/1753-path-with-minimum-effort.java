

import static java.util.Collections.min;





class Solution {
    int m, n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        //using Dijkstra's algo
        m = heights.length;
        n = heights[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]); // row, col, effort
        //since we have to find the path with minimum effort
        //we get minimum effort
        //initialize the array
        int[][] efforts = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }

         //we start from (0, 0) : so effort required to reach itself is 0
        efforts[0][0] = 0;

        minHeap.add(new int[]{0, 0, 0}); // row, col, effort
        while(!minHeap.isEmpty()){
            int[] cell = minHeap.poll();
            int r = cell[0], c = cell[1], effort = cell[2];

            if(r == m-1 && c == n-1){ // we reached the detination
                return effort;
            }

            //to get the neighbors from current cell
            for(int[] dir: directions){
                int row = r + dir[0], col = c +dir[1];
                if(isValid(row, col)){
                    int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[row][col])); //for a path we only consider maximum effort
                    if(newEffort < efforts[row][col]){//push it onto the heap
                        minHeap.add(new int[]{row, col, newEffort});
                        efforts[row][col] = newEffort;
                    }
                }
                
            }
        }

       return 0;
    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}