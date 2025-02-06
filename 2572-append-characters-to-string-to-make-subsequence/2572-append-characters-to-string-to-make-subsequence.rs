impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
       
        let mut s_len = s.len();
        let mut t_len = t.len();

        let mut s_idx = 0;
        let mut t_idx = 0;
        while s_idx < s_len && t_idx < t_len{
            if t[t_idx] == s[s_idx]{
                t_idx += 1;
                s_idx += 1;   
            }else{
                s_idx += 1;
            }
        }
        t[t_idx..].len() as i32
    }
}