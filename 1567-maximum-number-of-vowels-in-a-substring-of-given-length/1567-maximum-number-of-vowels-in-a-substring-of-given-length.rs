use std::collections::HashSet;

impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        let k = k as usize; // Convert k to usize since we'll use it as an index
        let vowels: HashSet<char> = vec!['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'].into_iter().collect();
        let chars: Vec<char> = s.chars().collect(); // Collect string characters into a vector

        let mut current_vowels = 0;
        for i in 0..k {
            if vowels.contains(&chars[i]) {
                current_vowels += 1;
            }
        }
        
        let mut max_vowels = current_vowels;
        
        for i in k..chars.len() {
            if vowels.contains(&chars[i]) {
                current_vowels += 1;
            }
            if vowels.contains(&chars[i - k]) {
                current_vowels -= 1;
            }
            max_vowels = max_vowels.max(current_vowels);
        }
        
        max_vowels
    }
}