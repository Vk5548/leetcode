impl Solution {
    pub fn partition_array(mut nums: Vec<i32>, k: i32) -> i32 {
        nums.sort_unstable();
        let mut nums = nums.as_slice();
        let mut result = 0;
        while let [first, other_nums @ ..] = nums{
            result += 1;
            let upper_bound = first + k;
            //get the partition_point
            let idx = other_nums.partition_point(|num| *num <= upper_bound);
            nums = unsafe { other_nums.get_unchecked(idx..)};
        }
        result
    }
}