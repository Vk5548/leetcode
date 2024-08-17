use std::collections::HashMap;

impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        let mut num_count: HashMap<i32, i32> = HashMap::new();
        let mut left: usize = 0;
        let mut curr_sum: i64 = 0;
        let mut max_sum: i64 = 0;

        for right in 0..nums.len() {
            let num = nums[right];
            curr_sum += num as i64;
            *num_count.entry(num).or_insert(0) += 1;

            if right - left + 1 == k as usize {
                if num_count.len() == k as usize {
                    max_sum = max_sum.max(curr_sum);
                }

                let left_num = nums[left];
                curr_sum -= left_num as i64;
                if let Some(count) = num_count.get_mut(&left_num) {
                    *count -= 1;
                    if *count == 0 {
                        num_count.remove(&left_num);
                    }
                }
                left += 1;
            }
        }

        max_sum
    }
}
