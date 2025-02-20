impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        let mut left = 0;
        let mut right = nums.len();
        while left < right{
            let mid = left +(right - left) / 2;
            if nums[mid] == target{
                return mid as i32;
            }
            if nums[mid] >= target{ //before the mid
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        left as i32
    }
}