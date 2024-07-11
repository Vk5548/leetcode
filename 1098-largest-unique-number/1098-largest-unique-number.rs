use std::collections::HashMap;
impl Solution {
    pub fn largest_unique_number(nums: Vec<i32>) -> i32 {
        let mut freq : HashMap<i32, i32> = HashMap::new();

        for &n in nums.iter(){
            *freq.entry(n).or_insert(0)+= 1;
        }

        let mut largest = -1;
        for (&key, &val) in freq.iter(){
            if val == 1{
                largest = largest.max(key);
            }
        }
        largest
    }
}