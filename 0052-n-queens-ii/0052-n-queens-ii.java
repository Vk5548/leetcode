class Solution {
    int size ;
    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    private int backtrack( int row, Set<Integer> diagonals, Set<Integer> antidiagonals, Set<Integer> cols){
        if(row == size){
            return 1;
        }

        int solutions = 0;
        for(int col = 0; col < size; col++){
            int diagonal = row - col;
            int antidiagonal = row + col;
            if(cols.contains(col)|| diagonals.contains(diagonal) || antidiagonals.contains(antidiagonal)){
                continue;
            }
            //place the queen.
            cols.add(col);
            diagonals.add(diagonal);
            antidiagonals.add(antidiagonal);
            solutions += backtrack(row + 1, diagonals, antidiagonals, cols);

            //remove
            cols.remove(col);
            diagonals.remove(diagonal);
            antidiagonals.remove(antidiagonal);
        }
        return solutions;
    }
}