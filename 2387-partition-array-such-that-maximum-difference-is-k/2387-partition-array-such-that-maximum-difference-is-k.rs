impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        //sort the partition_array
        let mut nums = nums;
        nums.sort();
        let mut res = 1;
        let mut start = nums[0];
        for i in 1..nums.len(){
            if nums[i] - start > k{
                start = nums[i];
                res += 1;
            } 
        }
        res
    }
}