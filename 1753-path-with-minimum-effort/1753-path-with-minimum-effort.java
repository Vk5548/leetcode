import java.util.*;

class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }// go the array

        //stsrt form source
        efforts[0][0] = 0; 
        //effort, row, col
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]); //minHeap
        minHeap.add(new int[]{0, 0, 0});

        while(!minHeap.isEmpty()){
            int[] arr = minHeap.poll();
            int effort = arr[0];
            int row = arr[1];
            int col = arr[2];

            if(row == m-1 && col == n-1){
                return effort;
            }
            if (effort > efforts[row][col]) continue;

            //traversing in all directions
            for(int[] dir: directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    int newMaxEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newMaxEffort < efforts[newRow][newCol]){
                        efforts[newRow][newCol] = newMaxEffort;
                        minHeap.offer(new int[]{newMaxEffort, newRow, newCol});
                    }
                }
               
                
            }
        }
        return 0;
    }
}