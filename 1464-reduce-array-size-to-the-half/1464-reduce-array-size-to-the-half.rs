use std::collections::HashMap;
impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        let mut freq = HashMap::new();
        for &num in arr.iter(){
            *freq.entry(num).or_insert(0) += 1;
        }// got the HashMap

        // get the values
        let mut values : Vec<_> = freq.values().collect();
        values.sort_by(|a,b| b.cmp(&a));


        let mut removed = 0;
        let mut bound = arr.len() / 2;
        let mut curr_removed = 0;

        for &count in &values{
            curr_removed += count;
            removed += 1;

            if curr_removed >= bound{
                break;
            }
        }
        removed
    }
}