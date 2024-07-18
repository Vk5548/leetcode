use std::collections::HashMap;
impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        // let mut anagram : HashMap<String, Vec<String>> = HashMap::new();
        // for stro in strs{
        //     let mut chrs = stro.chars().collect::<Vec<char>>();
        //     chrs.sort_unstable();
        //     let key = chrs.into_iter().collect::<String>();
        //     anagram.entry(key).or_insert(Vec::new()).push(stro);
        // }
        // anagram.into_values().collect()

        //NEW Solution : Old Solution is better
        let mut cache : HashMap<[i32; 26], Vec<String>> = HashMap::new();
        for s in strs{
            let mut charArray = s.chars().collect::<Vec<char>>();
            let mut letters: [i32; 26] = [0; 26];
            for c in charArray{
                print!("c iz {} ", c);
                letters[(c as u8 - 'a' as u8) as usize] += 1; // way to convert it into ascii value
            }
            match cache.get_mut(&letters) {
                None => { cache.insert(letters, vec![s]);}
                Some(v) => v.push(s)
            }
        }
        cache.into_values().collect()
    }
}