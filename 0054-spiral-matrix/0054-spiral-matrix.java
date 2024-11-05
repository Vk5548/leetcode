class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int left = 0, right = n - 1;
        int top = 0, down = m - 1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < total) {
            // Left to right
            for (int i = left; i <= right && res.size() < total; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // Top to bottom
            for (int i = top; i <= down && res.size() < total; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            // Right to left
            for (int i = right; i >= left && res.size() < total; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            // Bottom to top
            for (int i = down; i >= top && res.size() < total; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
