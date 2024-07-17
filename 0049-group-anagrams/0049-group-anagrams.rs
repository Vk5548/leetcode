use std::collections::HashMap;
impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut anagram : HashMap<String, Vec<String>> = HashMap::new();
        for stro in strs{
            let mut chrs = stro.chars().collect::<Vec<char>>();
            chrs.sort_unstable();
            let key = chrs.into_iter().collect::<String>();
            anagram.entry(key).or_insert(Vec::new()).push(stro);
        }
        anagram.into_values().collect()
    }
}