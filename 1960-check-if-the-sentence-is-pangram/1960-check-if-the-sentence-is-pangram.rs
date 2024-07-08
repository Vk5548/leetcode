use std::collections::HashSet;
impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        let mut set : HashSet<char> = HashSet::new();
        for ch in sentence.chars(){
            set.insert(ch);
        }
        set.len() == 26
        
    }
}