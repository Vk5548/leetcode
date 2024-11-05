class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize sets to track values in rows, columns, and 3x3 sub-boxes
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Generate unique keys for row, column, and sub-box entries
                    String rowKey = "row" + i + num;
                    String colKey = "col" + j + num;
                    String boxKey = "box" + (i / 3) + (j / 3) + num;
                    
                    // If any of these keys are already in the set, return false
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true; // All rows, columns, and sub-boxes are valid
    }
}
