impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        let s_bytes = s.as_bytes();
        let t_bytes = t.as_bytes();
        let mut maxLen = 0;
        let mut total = 0;
        let mut left  = 0;
        for right in 0..s.len(){
            total += (s_bytes[right] as i32 - t_bytes[right] as i32).abs();
            while total > max_cost{
                total-= (s_bytes[left] as i32 - t_bytes[left] as i32).abs();
                left += 1;
            }
            maxLen = maxLen.max((right - left + 1) as i32);
        }
        maxLen
    }
}