impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
       let mut rows = matrix.len();
       let mut cols = matrix[0].len();

       //find the target_row
       let mut target_row = 0;
       for row in 0..rows{
        if(matrix[row][0] <= target && matrix[row][cols - 1] >= target){
            target_row = row;
        }
       } 
       println!("{}", target_row);
       if target_row >= rows || target_row < 0{
        return false;
       }
       println!("{}", target_row);
       //find the lelemnt in target_row
       let mut left = 0;
       let mut right = cols;
       while(left < right){
            let mid = left + (right - left)/2;
            if matrix[target_row][mid] == target{
                return true;
            }
            if matrix[target_row][mid] >= target{
                right = mid;
            }else{
                left = mid + 1;
            }
       }
       false
    }
}