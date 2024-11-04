class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // we need to check for rows; which row contains the value 
        int rows = matrix.length;
        int cols = matrix[0].length;
        int targetRow = 0;
        for(targetRow = 0; targetRow< rows; targetRow++){
            if(target >= matrix[targetRow][0] && target <= matrix[targetRow][cols -1]){
                break;
            }
        }
        if(targetRow >= 0 && targetRow < rows){
            //start the bianry search just on this row
            int left = 0, right = cols - 1;

            while(left <= right){
               int mid = left + (right - left)/2;

                if(target == matrix[targetRow][mid]){
                    return true;
                }else if(target > matrix[targetRow][mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
           
        }
        return false;
    }
}