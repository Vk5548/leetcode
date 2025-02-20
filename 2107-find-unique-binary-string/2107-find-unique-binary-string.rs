use std::collections::HashSet;
impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        //convert it into a set
        let n = nums.len();
        let set = nums.into_iter().collect();
        let mut candidate = vec!['0'; n];
        let mut res = None;
        Self::backtrack(n, 0, &mut candidate, &set, &mut res);
        res.unwrap()

    }
    fn backtrack(n: usize, idx: usize, candidate : &mut Vec<char>, set : &HashSet<String>, res : &mut Option<String>){
        //base case: when we have completed the candidate upto index n

        if idx == n{
            //form the Vec<Char> into String
            let s: String = candidate.iter().collect();
            if !set.contains(&s){
                *res = Some(s);
            }
            return;
        }

        for &bit in &['0', '1']{
            candidate[idx] = bit;
            Self::backtrack(n, idx + 1, candidate, set, res);
            if res.is_some(){
                return
            }
        }
    }
}