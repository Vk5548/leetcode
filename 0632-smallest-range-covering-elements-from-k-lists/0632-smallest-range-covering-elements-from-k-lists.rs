use std::collections::BinaryHeap;
use std::cmp::{min, max, Reverse};

impl Solution {
    pub fn smallest_range(nums: Vec<Vec<i32>>) -> Vec<i32> {
        let k = nums.len();
        
        // Track current position in each list
        let mut indexes = vec![0; k];
        
        // Min heap to track current smallest element from each list
        let mut heap = BinaryHeap::new();
        
        // Track max value seen so far
        let mut max_val = i32::MIN;
        
        // Initial population of heap
        for (i, list) in nums.iter().enumerate() {
            let val = list[0];
            max_val = max(max_val, val);
            heap.push(Reverse((val, i)));
        }
        
        let mut range_start = 0;
        let mut range_end = i32::MAX;
        
        loop {
            let Reverse((min_val, list_idx)) = heap.pop().unwrap();
            
            // Update range if current range is smaller
            if max_val - min_val < range_end - range_start {
                range_start = min_val;
                range_end = max_val;
            }
            
            // Move to next element in this list
            indexes[list_idx] += 1;
            
            // If any list is exhausted, we're done
            if indexes[list_idx] == nums[list_idx].len() {
                break;
            }
            
            // Get next value and update max
            let next_val = nums[list_idx][indexes[list_idx]];
            max_val = max(max_val, next_val);
            heap.push(Reverse((next_val, list_idx)));
        }
        
        vec![range_start, range_end]
    }
}