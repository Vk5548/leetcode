class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, col = matrix[0].length;
        for(int i = 0; i < rows ; i++){
            //find the row
            if(target >= matrix[i][0] && target <= matrix[i][col- 1]){
                int left = 0, right = col, mid = -1;
                while(left <= right){
                    mid = (left + right) / 2;
                    if(target == matrix[i][mid]){
                        return true;
                    }else if( target > matrix[i][mid]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}