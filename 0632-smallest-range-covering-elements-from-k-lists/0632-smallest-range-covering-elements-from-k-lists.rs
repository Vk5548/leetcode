use std::collections::BinaryHeap;
use std::cmp::Reverse;

impl Solution {
    pub fn smallest_range(nums: Vec<Vec<i32>>) -> Vec<i32> {
        if nums.is_empty() || nums.iter().any(|list| list.is_empty()){
            return vec![];
        }
        let mut min_heap = BinaryHeap::new(); // does the lazy allocation
        let mut max_so_far = i32::MIN;

        //inserting the first elements from every list;
        for (i, list) in nums.iter().enumerate(){ // will give us the idx and the list at that idx
            if !list.is_empty(){
                min_heap.push(Reverse((list[0], i, 0))); //val, list_idx, ele_idx
                //also tracking the max_so_far
                max_so_far = max_so_far.max(list[0]);
            }
        }// pre-processing here is done; now we need to carry out the process until one of the list exhausts

        let mut best_range = (-1000_000, 1000_000); //STore the best range found, initializing it

        //Process the heap until one list is exhausted
        while let Some(Reverse((val, list_idx, ele_idx))) = min_heap.pop(){ //fetching the min value
            // getting current range
            let curr_range = max_so_far - val;
            if curr_range < best_range.1 - best_range.0 || (curr_range == best_range.1 - best_range.0 && val < best_range.0){
                best_range = (val, max_so_far);
            } // updating if we found the valid smaller range

            //adding the next element from the list that was popped out
            if ele_idx + 1 < nums[list_idx].len(){
                min_heap.push(Reverse((nums[list_idx][ele_idx + 1], list_idx, ele_idx + 1)));
                max_so_far = max_so_far.max(nums[list_idx][ele_idx + 1]);
            }else{
                break;
            }
        }

        vec![best_range.0, best_range.1]
    }
}