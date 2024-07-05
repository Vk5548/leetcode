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
    // pub fn pivot_index(nums: Vec<i32>) -> i32 {
    //     let mut left_sum = -nums[0];
    //     let mut pivot_left = nums[0];
    //     let mut right_sum: i32 = nums.iter().sum();

    //     for (i, v) in nums.iter().enumerate() {
    //         left_sum += pivot_left;
    //         right_sum -= v;
    //         if left_sum == right_sum {
    //             return i as i32;
    //         }
    //         pivot_left = *v;
    //     }
    //     -1
    // }
}