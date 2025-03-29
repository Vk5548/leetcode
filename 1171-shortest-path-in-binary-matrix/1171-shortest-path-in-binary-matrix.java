
/* 
Shortest Path 
n X n : grid[][]
len of shortest clear Path
clear path = 0,0 to n-1,n-1
: only visit "0" cells and
and its 8-directionally connected
and to shortest: i am thinking BFS here: level order traversal, since we don't have weights here:


CQ: 
1 can grid be [[]]? 0 or -1?
2. if no such path exists> -1?
3. what to do grid[0][0] = 1? -1?


A: BFS here: level order traversal, since we don't have weights here:
T: O(n*n)


*/
class Solution {
    int n;

    static class Pair {
        int r, c;
        Pair(int row, int col) {
            r = row;
            c = col;
        }
    }

    private boolean isValidPos(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;

        // Edge cases
        if (n == 0 || grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        if (n == 1) return 1; // single cell grid that's 0

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        grid[0][0] = 1; // mark as visited with step count
        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},         {0,1},
            {1,-1}, {1,0}, {1,1}
        };

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int r = p.r, c = p.c;

                if (r == n - 1 && c == n - 1) return level;

                for (int[] dir : directions) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (isValidPos(x, y, grid)) {
                        q.offer(new Pair(x, y));
                        grid[x][y] = 1; // mark visited
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
