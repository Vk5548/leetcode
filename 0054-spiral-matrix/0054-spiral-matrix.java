class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //left->down-> right->top and start again
        int curr = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int left = 0, right = n - 1; //cols
        int top = 0, down = m - 1;//rows
        List<Integer> res = new ArrayList<>();
        while(curr < m * n){
            //left to right: tracerse cols, row contsant
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
                curr++;
            }
            top++;
            if(curr == m*n){
                return res;
            }
            //top to bottom
            for(int i = top; i <= down; i++){
                res.add(matrix[i][right]);
                curr++;
            }
            right--;
            if(curr == m*n){
                return res;
            }

            //right to left
            for(int i = right ; i >= left; i--){
                res.add(matrix[down][i]);
                curr++;;
            }
            down--;
            if(curr == m*n){
                return res;
            }
            //bottom to top
            for(int i = down; i>= top; i--){
                res.add(matrix[i][left]);
                curr++;
            }
            left++;
            if(curr == m*n){
                return res;
            }
        }
        return res;
    }
}