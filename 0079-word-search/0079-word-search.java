class Solution {
     int m, n;
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        //start the search for word
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){
            return true;
        }

        if(!isValid(row, col) || board[row][col] == '^' || board[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] ='^';

        // Explore the four possible directions: up, down, left, and right
        boolean found = backtrack(board, word, row - 1, col, idx + 1) || // up
                        backtrack(board, word, row + 1, col, idx + 1) || // down
                        backtrack(board, word, row, col - 1, idx + 1) || // left
                        backtrack(board, word, row, col + 1, idx + 1);   // right
        board[row][col] = temp;

        return found;

    }
}