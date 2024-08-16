impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        //Question turns to: can have at most 1 '0' to have a valid string

        let mut left = 0;
        let mut curr = 0;
        let mut res = 0;
        for right in 0..nums.len(){
            if nums[right] == 0{
                curr += 1
            }
            while curr > 1{
                if nums[left] == 0{
                    curr -= 1
                }
                left += 1;
            }
            res = res.max(right-left +1);
        }
        res as i32
    }
}