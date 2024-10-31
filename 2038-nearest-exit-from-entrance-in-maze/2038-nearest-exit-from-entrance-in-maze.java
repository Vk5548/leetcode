class Solution {
    int m, n;
    int[][] seen;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> q = new LinkedList<>(); // 
        q.add(entrance);
        seen = new int[m][n];
        seen[entrance[0]][entrance[1]] = 1;
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){
                int[] cell = q.poll(); // current cell
                int row = cell[0];
                int col = cell[1];

                //to get the neighbors
                for(int[] direction: directions){
                    int newRow = row + direction[0] , newCol = col + direction[1];
                    if(isValid(newRow, newCol, maze) && isBoundaryCell(newRow, newCol)  && !(newRow == entrance[0] && newCol == entrance[1])){
                        System.out.println(newRow + ", " + newCol);
                        return level ;
                    }

                    if(isValid(newRow, newCol, maze) && seen[newRow][newCol] == 0 ){
                        seen[newRow][newCol] = 1;
                        q.add(new int[]{newRow, newCol});
                    }
                }



            }
        }
        return -1;
    }
    private boolean isValid(int x, int y, char[][] maze){
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.';
    }
    private boolean isBoundaryCell(int x, int y){
        return x == m-1 || x == 0 || y == 0 || y == n-1;
    }
}