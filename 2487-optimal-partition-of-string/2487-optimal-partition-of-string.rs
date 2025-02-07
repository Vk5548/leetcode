use std::collections::HashSet;

impl Solution {
    pub fn partition_string(s: String) -> i32 {
        let mut set : HashSet<char> = HashSet::new();
        let mut res = 1;
        for c in s.chars(){
            if set.contains(&c){
                res += 1;
                set = HashSet::new();
            }
            set.insert(c);
        }

        res
    }
}