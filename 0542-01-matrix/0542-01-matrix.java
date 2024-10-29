class State{
    int row, col, steps;
    State(int r, int c, int s){
        row = r;
        col = c;
        steps = s;
    }
}

class Solution {
    int m, n;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] seen;
    Queue<State> q = new LinkedList<>();
    public int[][] updateMatrix(int[][] mat) {
        //traversing each cell in the updateMatrix
        m = mat.length;
        n = mat[0].length;
        seen = new int[m][n]; // 0 and 1
        for(int i = 0; i < m; i++){ // rows
            for(int j = 0; j < n; j++){ //cols 
            // we will visit every cell ONLY ONCE here
            //every cell will be valid here
                //do we need seen?? I don'y know yet
                if(mat[i][j] == 0){
                    seen[i][j] = 1;
                    q.add(new State(i, j, 1)); // anything from this node will be step 1
                }
            }
        }
        bfs(mat);
        return mat;
    }
    private boolean isValidCell(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private void bfs(int[][] mat){
        while(!q.isEmpty()){
            State state = q.poll();
            int row = state.row, col = state.col, steps = state.steps;

            // getting the neighbors of the current cell which are not yet visited:
            for(int[] direction : directions){
                int newRow = row + direction[0], newCol = col + direction[1]; 
                if(isValidCell(newRow, newCol) && seen[newRow][newCol] == 0 ){
                    seen[newRow][newCol] = 1;
                    mat[newRow][newCol] = steps;
                    q.add(new State(newRow, newCol, steps +1));
                }
            }
        }
    }
}