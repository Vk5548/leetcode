impl Solution {
    pub fn num_subarray_product_less_than_k(nums: Vec<i32>, k: i32) -> i32 {
        if k <= 1{
            return 0;
        }
        let (mut ans, mut left) = (0, 0);
        let mut curr = 1;
        // No need to handle when nums[i] = 0
        for right in 0..nums.len(){
            curr *= nums[right];
            while curr >= k{
                curr /= nums[left];
                left+=1;
            }
            ans += right - left + 1;
        }
        ans as i32
    }
}