use std::collections::HashSet;
impl Solution {
    pub fn count_elements(arr: Vec<i32>) -> i32 {
        let mut set: HashSet<i32> = HashSet::new();
        let mut count = 0;
        for i in 0..arr.len(){
            set.insert((arr[i]));
        }
        for i in 0..arr.len(){
            if set.contains(&(arr[i] + 1)){
                count+= 1;
            }
        }
        count
    }
}