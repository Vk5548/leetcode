use std::collections::HashSet;
impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        // get the set and length
        let n = nums.len();
        let set: HashSet<String> = nums.into_iter().collect();

        for i in 0..=n{
            let candidate = format!("{:0width$b}", i, width = n);
            if !set.contains(&candidate){
                return candidate;
            }
        }
        unreachable!("there has to be a string which is not in the set as we are iterating through n + 1");
    }
}