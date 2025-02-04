impl Solution {
    pub fn max_ascending_sum(nums: Vec<i32>) -> i32 {
        let mut curr = nums[0];
        let mut max_sum = 0;
        for i in 1..nums.len(){
            println!("curr nums[i] = {}", nums[i]);
            if nums[i] > nums[i-1]{
                curr += nums[i];
                println!("curr  = {}", curr);
            }else{
                max_sum = max_sum.max(curr);
                println!("max_sum  = {}", max_sum);
                curr =nums[i];
                println!("curr  = {}", curr);
            }
        }
        max_sum = max_sum.max(curr);
        max_sum
    }
}