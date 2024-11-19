
use std::collections::BinaryHeap;
use std::cmp::Ordering;

#[derive(Debug, Copy, Clone, PartialEq, PartialOrd)]
struct FloatWrapper(f64);

impl Eq for FloatWrapper {}

impl Ord for FloatWrapper {
    fn cmp(&self, other: &Self) -> Ordering {
        self.partial_cmp(other).unwrap()
    }
}

impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        //we will need heap and max-heap at that because, we need
        //minimum number of operations 
        let mut heap = BinaryHeap::new();
        let mut sum = 0.0; // need to use f64, floating-point to get to the solution
        

        for &num in nums.iter(){
            sum += num as f64;
            heap.push(FloatWrapper(num as f64));
        }//got the heap and the sum
        let mut res = 0;
        let required_val = sum/2.0;

        let epsilon = 1e-6; // or any small positive number 

        while sum - required_val > epsilon{
            if let Some(FloatWrapper(val)) = heap.pop(){ // will return max value, we half the avle and add it back to the heap 
                let half_val = val/2.0;
                sum -= half_val;
                heap.push(FloatWrapper(half_val as f64));
                res += 1;
            }
        }
        res
    }
}

//ISSUE: f64 doesn't implement Ord : Wrapping f64 values in a custom struct that implements Ord or using the
 //ordered-float crate resolves the issue.
