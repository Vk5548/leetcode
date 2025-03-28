/* 
given a matrix : m x n board[][]
M : unrevealed mine
E: unrevealed empty Squares
B : revealed blank Sq that has no adjacent mines in all 8 directions
digit 1 to 8: how many mines are present to each revelaed Squares
X: revelaed mine

click[][] clic[] -> [cr cc] -> among all unreveled Squares

if it is 
'M' : Game over; change t to 'X'
'E' : with no adjacnet mines revealed: -> 'B'
== and all of its adjacent unre sqyare should be revealed recursively
'E'- with atleast 1 sqaure: chnage it to 1 to 8
Return the board such that no more sqaures is revelead

if board[r][c] == 'M'
    board[r][c] = 'X';
    Return
else if 
    numMines = getAdajacentNumber of Mines
    if numMines = 0
        board[r][c] = 'B'
        //recursive call for all neighbors
    else
        board[r][c] = numMines;
*/

class Solution {
    int numRows;
    int numCols;
    char[][] board;
    private boolean ifValid(int r, int c){ // O(1)
        return r >= 0 && r < numRows && c >= 0 && c < numCols;
    }
    private int calculateNumOfMines(int r, int c){ // O(1)
        int numMines = 0;
        for(int i = r-1; i <= r+1; i++){
            for(int j = c-1 ; j <= c+1; j++){
                if(ifValid(i, j) && board[i][j] == 'M'){
                    numMines++;
                }
            }
        }
        return numMines;
    }

    // O(m * n) worst case DFS
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0){ //empty board
            return board;
        }
        this.board = board;
        numRows = board.length;
        numCols = board[0].length;
        updateBoardRecursive(click[0], click[1]);
        return this.board;
    }
    // O(m * n) worst case DFS; all empty cells visited
    private void updateBoardRecursive(int r, int c){
        if (board[r][c] == 'M'){ // O(1)
            board[r][c] = 'X'; // game over
            return;
        }
        int numMines = calculateNumOfMines(r, c); // O(1)
        if (numMines != 0){
            board[r][c] = (char) (numMines + '0');  // O(1)
        }else{ //recursive call. : 
            board[r][c] = 'B';
            for(int i = r-1; i <= r+1; i++){
            for(int j = c-1 ; j <= c+1; j++){
                if(ifValid(i, j) && board[i][j] == 'E'){
                    updateBoardRecursive(i, j);
                }
            }
        }
        }
    }
}