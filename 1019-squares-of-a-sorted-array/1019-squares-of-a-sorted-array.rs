impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        let mut res : Vec<i32> = Vec::with_capacity(nums.len());
        for i in 0..nums.len(){
            res.push(nums[i].pow(2));
        }
        res.sort(); //sorts in place fn sort(&mut self); it mutates the vector not return it
        res
    }
}