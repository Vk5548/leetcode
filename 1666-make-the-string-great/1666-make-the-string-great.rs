impl Solution {
    pub fn make_good(s: String) -> String {
        let mut stk = Vec::with_capacity(s.len());
        for ch in s.chars(){
            if let Some(&last) = stk.last(){
                if(last as i32 - ch as i32).abs() == 32{
                    stk.pop();
                }else{
                    stk.push(ch);
                }
            }else{
                stk.push(ch);
            }
        }
        stk.iter().collect()
    }
}