impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        let (mut res, mut odd) = (0, 0);
        let (mut l, mut m) = (0, 0);

        for r in 0..nums.len() {
            if nums[r] % 2 != 0 {
                odd += 1;
            }

            while odd > k {
                if nums[l] % 2 != 0 {
                    odd -= 1;
                }
                l += 1;
                m = l;
            }

            if odd == k {
                while nums[m] % 2 == 0 {
                    m += 1;
                }
                res += (m - l) as i32 + 1;
            }
        }
        res as i32
    }
}