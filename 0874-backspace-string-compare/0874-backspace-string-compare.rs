impl Solution {
    fn process_string(s: &str) -> Vec<char>{
        let mut result = Vec::new();
         for ch in s.chars(){
            if ch == '#'{
                result.pop();
            }else{
                result.push(ch);
            }
        }
        result
    }
    pub fn backspace_compare(s: String, t: String) -> bool {
        Self::process_string(&s) == Self::process_string(&t)

    }
}