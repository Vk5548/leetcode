use std::collections::HashSet;
impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        for ch in 'a'..='z'{
            if !sentence.contains(ch){
                return false;
            }
        }
        true
        
    }
}