use std::collections::BinaryHeap;
use std::cmp::Reverse;

impl Solution {
    pub fn min_meeting_rooms(mut intervals: Vec<Vec<i32>>) -> i32 {
        if intervals.is_empty(){
            return 0;
        }
        if intervals.len() == 1{
            return 1;
        }

        intervals.sort_unstable_by(|a, b| a[0].cmp(&b[0]));

        let mut min_heap : BinaryHeap<Reverse<i32>> = BinaryHeap::new();

        min_heap.push(Reverse(intervals[0][1])); //adding end times

        for i in 1..intervals.len(){
            if let Some(Reverse(earliest_end)) = min_heap.peek(){
                if intervals[i][0] >= *earliest_end{
                    min_heap.pop();
                }
            }
            min_heap.push(Reverse(intervals[i][1]));
        }
        min_heap.len() as i32

    }
}