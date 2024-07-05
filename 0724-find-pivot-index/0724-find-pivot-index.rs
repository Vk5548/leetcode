impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        let total: i32 = nums.iter().sum();
        let mut left_sum = 0;

        for i in 0..nums.len() {
            if left_sum * 2 + nums[i] == total {
                return i as i32;
            }
            left_sum += nums[i];
        }
        -1
    }
}