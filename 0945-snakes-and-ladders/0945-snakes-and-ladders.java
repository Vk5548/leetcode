import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // Start at cell 1 with 0 moves
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cell = current[0];
            int moves = current[1];

            // If we reach the last cell, return the number of moves
            if (cell == n * n) {
                return moves;
            }

            // Try moving from 1 to 6 steps from the current cell
            for (int i = 1; i <= 6; i++) {
                int nextCell = cell + i;
                if (nextCell > n * n) break; // Out of bounds

                // Calculate the board position from the cell number
                int[] pos = getBoardPosition(nextCell, n);
                int row = pos[0];
                int col = pos[1];

                // If there is a ladder or snake, move to the destination cell
                if (board[row][col] != -1) {
                    nextCell = board[row][col];
                }

                // If the cell hasn't been visited, add it to the queue
                if (!visited[nextCell]) {
                    visited[nextCell] = true;
                    queue.add(new int[]{nextCell, moves + 1});
                }
            }
        }
        return -1; // If we can't reach the last cell
    }

    // Convert the cell number to row and column on the board
    private int[] getBoardPosition(int cell, int n) {
        int row = n - 1 - (cell - 1) / n; // The row, from bottom to top
        int col = (row % 2 == n % 2) ? (n - 1 - (cell - 1) % n) : (cell - 1) % n; // Column direction alternates
        return new int[]{row, col};
    }
}
