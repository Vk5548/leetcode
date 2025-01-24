impl Solution {
    pub fn max_number_of_apples(mut weight: Vec<i32>) -> i32 {
        weight.sort_unstable();
        let mut num_apples = 0;
        let mut curr_wt = 0;
        for &wt in weight.iter(){
            if wt + curr_wt <= 5000{
                num_apples+= 1;
                curr_wt+= wt;
            }else{
                break;
            }
        }
        num_apples
    }
}