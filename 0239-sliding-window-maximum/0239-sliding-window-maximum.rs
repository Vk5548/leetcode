use std::collections::VecDeque;

impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut left: usize = 0;
        let mut queue: VecDeque<usize> = VecDeque::new();
        let mut res : Vec<i32> = Vec::new();
        for right in 0..nums.len(){
            while let Some(&q) = queue.back(){
                if nums[q] < nums[right]{
                    queue.pop_back();
                }else{
                    break;
                }
            }
            queue.push_back(right);
            if right - left + 1 == k as usize{
                if let Some(&q) = queue.front(){
                    res.push(nums[q]);
                    if q == left{
                        queue.pop_front();
                    }
                    left += 1;
                }
            }
        }
        res
    }
}