use std::collections::HashMap;
impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut count : HashMap<i32, i32> = HashMap::new();
        count.insert(0, 1);
        let mut curr = 0;
        let mut ans = 0;
        for n in &nums{
            curr += *n;
            if let Some(&num) = count.get(&(curr - k)){
                ans += num
            }
            *count.entry(curr).or_insert(0)+= 1
        }
        ans
    }
}