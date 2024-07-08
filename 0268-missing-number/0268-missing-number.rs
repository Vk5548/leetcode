impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        for i in 0..=nums.len(){
            if !nums.contains(&(i as i32)){
                return (i as i32);
            }
        }
        -1
    }
}