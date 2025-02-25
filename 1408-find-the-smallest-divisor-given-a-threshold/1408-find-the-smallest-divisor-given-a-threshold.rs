impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        let &max_val = nums.iter().max().unwrap();
        let (mut left, mut right) = (1, max_val);
        while left < right {
            let mid = left + (right - left) / 2;
            let sum: i32 = nums.iter().map(|&num| (num + mid - 1) / mid).sum();
            if sum <= threshold {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}
