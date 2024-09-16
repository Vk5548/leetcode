impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        let mut array: Vec<char> = s.chars().collect();
        let mut end : isize = -1;
        for ch in s.chars(){
            if end >= 0 && array[end as usize] == ch{
                end -= 1;
            }else{
                end += 1;
                array[end as usize] = ch
            }
        }
        if end == -1{
            return "".to_string();
        }
        array[..=end as usize].iter().collect()
    }
}