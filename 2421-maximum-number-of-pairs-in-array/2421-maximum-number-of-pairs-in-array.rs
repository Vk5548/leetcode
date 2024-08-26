use std::collections::HashSet;
impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        let mut ans : Vec<i32> = vec![0,0];
        let mut track : HashSet<i32> = HashSet::new();
        for num in nums{
            if track.contains(&num){
                ans[0]+= 1;
                track.remove(&num);
            }else{
                track.insert(num);
            }
        }
        ans[1] = track.len() as i32;
        ans
    }
}