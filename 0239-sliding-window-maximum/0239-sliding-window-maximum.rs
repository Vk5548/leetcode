use std::collections::VecDeque;

impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let k = k as usize; // Convert k to usize
        if nums.is_empty() || k == 0 {
            return vec![];
        }
        let mut queue: VecDeque<usize> = VecDeque::new();
        let mut result = Vec::new();

        // Process the first k elements
        for i in 0..k {
            while let Some(&last) = queue.back() {
                if nums[last] <= nums[i] {
                    queue.pop_back();
                } else {
                    break;
                }
            }
            queue.push_back(i);
        }
        result.push(nums[*queue.front().unwrap()]);

        // Process the rest of the elements
        for right in k..nums.len() {
            // Remove indices that are out of the current window
            if let Some(&front) = queue.front() {
                if front <= right - k {
                    queue.pop_front();
                }
            }

            // Remove indices whose corresponding values are less than or equal to nums[right]
            while let Some(&last) = queue.back() {
                if nums[last] <= nums[right] {
                    queue.pop_back();
                } else {
                    break;
                }
            }
            queue.push_back(right);

            result.push(nums[*queue.front().unwrap()]);
        }
        result
    }
}
