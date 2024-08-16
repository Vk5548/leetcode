impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        let (mut i, mut j) = (0, 0);
        let vec_s = s.chars().collect::<Vec<char>>();
        let vec_t = t.chars().collect::<Vec<char>>();
        while i < s.len() && j < t.len(){
            if vec_s[i] == vec_t[j]{
                i += 1;
            }
            j += 1;
        }
        
        if i >= s.len(){
            true
        }else{
            false
        }
    }
}