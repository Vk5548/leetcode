use std::cmp::{max, min};
impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        let mut intervals : Vec<Vec<i32>> = Vec::with_capacity((n+1) as usize);

        for (i, range) in ranges.iter().enumerate(){
            let i = i as i32;
            intervals.push(vec![0.max(i - range), n.min(i + range)]);
        }

        //sort the intervals based on first index
        intervals.sort_by(|a,b| a[0].cmp(&b[0]).then(b[1].cmp(&a[1])));

        let mut count = 0;
        let mut current_end = 0;
        let mut idx: usize = 0;

        while current_end < n{
            let mut next_end = current_end;
            //extend the interval as far as possible
            while idx < intervals.len() && intervals[idx][0] <= current_end{
                next_end = next_end.max(intervals[idx][1]);
                idx += 1;
            }

            if next_end == current_end{ // not possible to reach ahead
                return -1;
            }
            count += 1;
            current_end = next_end;
        }
        count
    }
}