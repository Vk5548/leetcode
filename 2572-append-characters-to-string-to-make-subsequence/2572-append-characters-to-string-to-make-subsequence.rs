impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        let mut s = &*s;
        for (i, c) in t.chars().enumerate(){
            let Some((_, rest)) = s.split_once(c) else {
                return (t.len() - i) as i32;
            };
            s = rest;
        }
        0
    }
}