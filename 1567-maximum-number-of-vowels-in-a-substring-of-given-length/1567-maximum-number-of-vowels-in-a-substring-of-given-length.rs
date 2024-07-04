use std::collections::HashSet;
impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        let k : usize = k as usize;
        let mut currVowels = 0;
        let vowels: HashSet<char> = vec!['a', 'e', 'i', 'o', 'u'].into_iter().collect();
        let chars: Vec<char> = s.chars().collect();
        for i in 0..k{
            if vowels.contains(&chars[i]){
                currVowels += 1;
            }
        }
        let mut maxVowels = currVowels;
        for i in k..chars.len(){
            if vowels.contains(&chars[i]){
                currVowels += 1;
            }
            if vowels.contains(&chars[i - k]){
                currVowels -= 1;
            }
            maxVowels = maxVowels.max(currVowels);
        }
        maxVowels
    }
}